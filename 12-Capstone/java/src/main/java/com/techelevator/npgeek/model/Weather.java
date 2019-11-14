package com.techelevator.npgeek.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public String createClimateRecommendation() {
	    Map<String, String> climateRecommendationMap = new HashMap<>();
	    
	    climateRecommendationMap.put("snow", "Remember to wear snowshoes");
	    climateRecommendationMap.put("rain", "Bring your raingear and wear waterproof shoes");
	    climateRecommendationMap.put("thunderstorms", "Seek shelter and avoid hiking on exposed ridges");
	    climateRecommendationMap.put("sun", "Remember to pack sunblock");
	    
	    return climateRecommendationMap.getOrDefault(forecast, "");
	}
	
	public List<String> createTemperatureRecommendations() {
	    List<String> temperatureRecommendations = new ArrayList<>();
	    
	    if (high - low > 20) {
	        temperatureRecommendations.add("Remember to wear breathable layers");
	    }  
	    if (high > 75) {
	        temperatureRecommendations.add("Bring an extra gallon of water");
	    }
	    if (high < 20) {
	        temperatureRecommendations.add("Make sure you wear a thick coat");
	    }
	    
	    return temperatureRecommendations;
	}
	
	public String createDate() {
	    LocalDate now = LocalDate.now();
	    
	    LocalDate date = now.plusDays(fiveDayForecastValue-1);
	    
        return date.format(DateTimeFormatter.ofPattern("E, MMM dd"));
	}
    
}
