package com.techelevator.npgeek.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class WeatherTest {

    private Weather weather = new Weather();
    
    @Test
    public void testAllSettersGettersAndCreationMethods() {
        int fiveDayForecastValue = 3;
        String forecast = "cloudy";
        int high = 102;
        int low = 85;
        String parkCode = "FNP"; 
        
        weather.setFiveDayForecastValue(fiveDayForecastValue);
        weather.setForecast(forecast);
        weather.setHigh(high);
        weather.setLow(low);
        weather.setParkCode(parkCode);
        
        assertEquals(fiveDayForecastValue, weather.getFiveDayForecastValue());
        assertEquals(forecast, weather.getForecast());
        assertEquals(high, weather.getHigh());
        assertEquals(low, weather.getLow());
        assertEquals(parkCode, weather.getParkCode());
        
        /* Testing Creation Methods */
        assertEquals("img/weather/cloudy.png", weather.createWeatherImage());
        assertEquals("Bring an extra gallon of water", weather.createTemperatureRecommendations().get(0));
        assertEquals("", weather.createClimateRecommendation());
        
        /* Testing Date Method */
        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(fiveDayForecastValue-1);
        String expectedDate = date.format(DateTimeFormatter.ofPattern("E, MMM dd"));
        
        assertEquals(expectedDate, weather.createDate());        
    }

}
