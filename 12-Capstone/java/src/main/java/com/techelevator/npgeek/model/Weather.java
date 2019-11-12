package com.techelevator.npgeek.model;

import java.util.HashMap;
import java.util.Map;

public class Weather {

    private String parkCode;
    private int fiveDayForecastValue;
    private int low;
    private int high;
    private String forecast;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public int getFiveDayForecastValue() {
        return fiveDayForecastValue;
    }

    public void setFiveDayForecastValue(int fiveDayForecastValue) {
        this.fiveDayForecastValue = fiveDayForecastValue;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

	public String createWeatherImage() {
		Map<String, String> weatherImageMap = new HashMap<>();
		weatherImageMap.put("cloudy", "img/weather/cloudy.png");
		weatherImageMap.put("partly cloudy", "img/weather/partlyCloudy.png");
		weatherImageMap.put("rain", "img/weather/rain.png");
		weatherImageMap.put("snow", "img/weather/snow.png");
		weatherImageMap.put("sunny", "img/weather/sunny.png");
		weatherImageMap.put("thunderstorms", "img/weather/thunderstorms.png");
		
		return weatherImageMap.get(forecast);
	}
    
}
