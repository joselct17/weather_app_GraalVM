package com.devjose.weather;

import com.devjose.weather.service.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

	private final WeatherService weatherService;

    public WeatherApplication(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: weather <city>");
			return;
		}

		String city = args[0];
		weatherService.getWeather(city);
	}

}
