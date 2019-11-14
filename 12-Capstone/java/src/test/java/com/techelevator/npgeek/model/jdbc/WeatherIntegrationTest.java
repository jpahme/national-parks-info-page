package com.techelevator.npgeek.model.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.npgeek.model.JDBCWeatherDAO;
import com.techelevator.npgeek.model.Weather;

public class WeatherIntegrationTest extends DAOIntegrationTest {

    private JDBCWeatherDAO weatherDAO;
	
    @BeforeClass
    public static void SetUpBeforeClass() throws Exception {
        setupDataSource();
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        closeDataSource();
    }
    
    @Before
    public void setUp() throws Exception {
        weatherDAO = new JDBCWeatherDAO(getDataSource());
    }

    @After
    public void tearDown() throws Exception {
        rollback();
    }
    
    /* Note all test cases below depend on your instance of database */
    
    @Test
    public void getWeatherForecastByParkCodeWillReturnTheCorrespondingWeatherForecast() {
        String testParkCode = "GNP";
        List<Weather> actualResult = weatherDAO.getWeatherForecastByParkCode(testParkCode);
        assertNotNull(actualResult.get(0));
    }

}
