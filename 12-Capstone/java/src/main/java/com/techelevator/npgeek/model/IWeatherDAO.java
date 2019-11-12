package com.techelevator.npgeek.model;

import java.util.List;

public interface IWeatherDAO {
    
    public List<Weather> getWeatherForecastByParkCode(String parkCode);
    
}
