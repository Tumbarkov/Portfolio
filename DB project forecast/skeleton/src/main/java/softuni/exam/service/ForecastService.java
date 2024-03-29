package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

// TODO: Implement all methods
public interface ForecastService {

    boolean areImported();

    String readForecastsFromFile() throws IOException, JAXBException;
	
	String importForecasts() throws IOException, JAXBException;

    String exportForecasts() throws JAXBException, FileNotFoundException;
}
