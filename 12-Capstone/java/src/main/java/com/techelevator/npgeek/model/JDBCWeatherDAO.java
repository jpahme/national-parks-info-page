package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * The Class JDBCWeatherDAO.
 */
@Component
public class JDBCWeatherDAO implements IWeatherDAO {
    
    /** The jdbc template. */
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Instantiates a new JDBC weather DAO.
     *
     * @param dataSource the data source
     */
    @Autowired
    public JDBCWeatherDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Gets the weather forecast by park code.
     *
     * @param parkCode the park code
     * @return the weather forecast by park code
     */
    @Override
    public List<Weather> getWeatherForecastByParkCode(String parkCode) {
        List<Weather> weatherForecast = new ArrayList<>();
        String sql = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
        
        while(results.next()) {
            weatherForecast.add(mapRowToWeather(results));
        }
        
        return weatherForecast;
    }

    /**
     * Map row to weather.
     *
     * @param row the row
     * @return the weather
     */
    private Weather mapRowToWeather(SqlRowSet row) {
        Weather weather = new Weather();
        
        weather.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
        weather.setForecast(row.getString("forecast"));
        weather.setHigh(row.getInt("high"));
        weather.setLow(row.getInt("low"));
        weather.setParkCode(row.getString("parkcode"));
        
        return weather;
    }

}
