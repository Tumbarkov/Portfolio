"Data Base Forecast project" 
The skeleton contains a certain architecture (MVC) with several classes, some of which were completely empty. I had to make the classes, the logic behind the queries and the fitration for certain data.

*IMPORTANT* if you want to run the program you will have to connect it to you local database from skeleton/src/main/resourses/application.properties/
spring.datasource.username=
spring.datasource.password=
The Skeleton includes the files which you will need to seed the database.

After the ajustments run the program and in your browser search for: localhost: and the port you are using //for me is 8080//

Once in the program you should first click "Import JSON" -> Import Countries then Import Cities after that import XML -> Import Forecasts. 

The final part is extracting info from the database: 
the city name, 
min temperature (to the second digit after decimal point), 
max temperature (to the second digit after the decimal point),
sunrise and sunset of the forecast. 

Filtering only forecasts from sunday and from cities with less than 150000 citizens, order them by max temperature in descending order, then by the forecast id in ascending order in this format:
	"City: {cityName}:
   		-min temperature: {minTemperature}
   		--max temperature: {maxTemperature}
   		---sunrise: {sunrise}
----sunset: {sunset}
