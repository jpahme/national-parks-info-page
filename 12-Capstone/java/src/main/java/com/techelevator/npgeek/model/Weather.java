package com.techelevator.npgeek.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class Weather.
 */
public class Weather {

    /** The park code. */
    private String parkCode;
    
    /** The five day forecast value. */
    private int fiveDayForecastValue;
    
    /** The low. */
    private int low;
    
    /** The high. */
    private int high;
    
    /** The forecast. */
    private String forecast;

    /**
     * Gets the park code.
     *
     * @return the park code
     */
    public String getParkCode() {
        return parkCode;
    }

    /**
     * Sets the park code.
     *
     * @param parkCode the new park code
     */
    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    /**
     * Gets the five day forecast value.
     *
     * @return the five day forecast value
     */
    public int getFiveDayForecastValue() {
        return fiveDayForecastValue;
    }

    /**
     * Sets the five day forecast value.
     *
     * @param fiveDayForecastValue the new five day forecast value
     */
    public void setFiveDayForecastValue(int fiveDayForecastValue) {
        this.fiveDayForecastValue = fiveDayForecastValue;
    }

    /**
     * Gets the low.
     *
     * @return the low
     */
    public int getLow() {
        return low;
    }

    /**
     * Sets the low.
     *
     * @param low the new low
     */
    public void setLow(int low) {
        this.low = low;
    }

    /**
     * Gets the high.
     *
     * @return the high
     */
    public int getHigh() {
        return high;
    }

    /**
     * Sets the high.
     *
     * @param high the new high
     */
    public void setHigh(int high) {
        this.high = high;
    }

    /**
     * Gets the forecast.
     *
     * @return the forecast
     */
    public String getForecast() {
        return forecast;
    }

    /**
     * Sets the forecast.
     *
     * @param forecast the new forecast
     */
    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

	/**
	 * Creates the weather image.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Creates the climate recommendation.
	 *
	 * @return the string
	 */
	public String createClimateRecommendation() {
	    Map<String, String> climateRecommendationMap = new HashMap<>();
	    
	    climateRecommendationMap.put("snow", "Remember to wear snowshoes");
	    climateRecommendationMap.put("rain", "Bring your raingear and wear waterproof shoes");
	    climateRecommendationMap.put("thunderstorms", "Seek shelter and avoid hiking on exposed ridges");
	    climateRecommendationMap.put("sun", "Remember to pack sunblock");
	    
	    return climateRecommendationMap.getOrDefault(forecast, "");
	}
	
	/**
	 * Creates the temperature recommendations.
	 *
	 * @return the list
	 */
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
	
	/**
	 * Creates the date.
	 *
	 * @return the string
	 */
	public String createDate() {
	    LocalDate now = LocalDate.now();
	    
	    LocalDate date = now.plusDays(fiveDayForecastValue-1);
	    
        return date.format(DateTimeFormatter.ofPattern("E, MMM dd"));
	}
    
}
