package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.constants.Messages.INVALID_CITY;
import static softuni.exam.constants.Messages.VALID_CITY;

@Service
public class CityServiceImpl implements CityService {
    public static final Path CITIES_PATH= Path.of("src/main/resources/files/json/cities.json");
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtils validationUtils;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {

        final StringBuilder stringBuilder = new StringBuilder();

        final List<City> cities = Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDto[].class))
                .filter(dto -> {
                    boolean isValid = this.validationUtils.isValid(dto);
                    if (this.cityRepository.findFirstByCityName(dto.getCityName()).isPresent()) {
                        isValid = false;
                    }
                    if (isValid) {
                        stringBuilder.append(String.format(VALID_CITY,
                                dto.getCityName(),
                                dto.getPopulation()));

                        if (this.countryRepository.findById(dto.getCountry()).isPresent()) {
                            City cityToSave = this.modelMapper.map(dto, City.class);
                            cityToSave.setCountry(this.countryRepository.findById(dto.getCountry()).get());
                            this.cityRepository.save(cityToSave);
                        } else {
                            stringBuilder.append("Error!").append(System.lineSeparator());
                        }
                    } else {
                        stringBuilder.append(INVALID_CITY).append(System.lineSeparator());
                    }
                    return isValid;

                }).map(dto -> this.modelMapper.map(dto, City.class)).toList();

        return stringBuilder.toString();
    }
}
