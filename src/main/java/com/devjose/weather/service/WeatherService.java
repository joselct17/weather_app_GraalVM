package com.devjose.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient webClient = WebClient.create("https://wttr.in");

    public void getWeather(String city) {
        String response = webClient.get()
                .uri("/{city}?format=j1", city)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Weather for " + city + ":");
        System.out.println(response);
    }

}
