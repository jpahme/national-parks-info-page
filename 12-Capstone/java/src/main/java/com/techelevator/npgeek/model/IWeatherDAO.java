package com.techelevator.npgeek.model;

import java.util.List;

/**
 * The Interface IWeatherDAO.
 */
public interface IWeatherDAO {
    
    /**
     * Gets the weather forecast by park code.
     *
     * @param parkCode the park code
     * @return the weather forecast by park code
     */
    public List<Weather> getWeatherForecastByParkCode(String parkCode);
    
}
