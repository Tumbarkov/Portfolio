package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastsWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.constants.Messages.INVALID_FORECAST;
import static softuni.exam.constants.Messages.VALID_FORECAST;

@Service
public class ForecastServiceImpl implements ForecastService {
    public static final File FORECAST_PATH= Path.of("src/main/resources/files/xml/forecasts.xml").toFile();
    public final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;
    private final String PRINT_FORMAT =  "City: %s:%n -min temperature: %.2f%n--max temperature: %.2f%n---sunrise: %s%n----sunset: %s%n";

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException, JAXBException {
        return Files.readString(FORECAST_PATH.toPath());
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder stringBuilder= new StringBuilder();

        ForecastsWrapperDto forecastsWrapperDto =
                xmlParser.fromFile(FORECAST_PATH, ForecastsWrapperDto.class);
        
        List<ForecastImportDto> forecasts = forecastsWrapperDto.getForecasts();

        for (ForecastImportDto forecast : forecasts) {
            boolean isValid = validationUtils.isValid(forecast);

            if (isValid) {
                if (cityRepository.findFirstById(forecast.getCity()).isPresent()) {
                    City refCity = cityRepository.findFirstById(forecast.getCity()).get();

                    Forecast forecastToSave = this.modelMapper.map(forecast, Forecast.class);

                    forecastToSave.setCity(refCity);

                    forecastToSave.setSunset(LocalTime.parse(forecast.getSunset(),
                            DateTimeFormatter.ofPattern("HH:mm:ss")));

                    forecastToSave.setSunrise(LocalTime.parse(forecast.getSunrise(),
                            DateTimeFormatter.ofPattern("HH:mm:ss")));

                    this.forecastRepository.saveAndFlush(forecastToSave);

                    stringBuilder.append(VALID_FORECAST);
                }
                continue;
            }
            stringBuilder.append(INVALID_FORECAST).append(System.lineSeparator());
        }
        
        return null;
    }

    @Override
    public String exportForecasts() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        Set<Forecast> forecasts = this.forecastRepository
                .findByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDesc(DayOfWeek.SUNDAY, 150000L)
                .orElseThrow(NoSuchElementException::new);

        return forecasts.stream()
                .map(forecast ->String.format(PRINT_FORMAT,
                forecast.getCity().getCityName(),
                forecast.getMinTemperature(),
                forecast.getMaxTemperature(),
                forecast.getSunrise(),
                forecast.getSunset()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
