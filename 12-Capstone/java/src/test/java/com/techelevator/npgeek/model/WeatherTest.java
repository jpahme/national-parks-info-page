package com.techelevator.npgeek.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherTest {

    private Weather weather = new Weather();
    
    @Test
    public void testAllSettersAndGetters() {
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
    }

}
