package com.techelevator.npgeek.model.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.npgeek.model.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;

public class ParkIntegrationTest extends DAOIntegrationTest {

    private JDBCParkDAO parkDAO;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        setupDataSource();
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        closeDataSource();
    }
    
    @Before
    public void setUp() throws Exception {
        parkDAO = new JDBCParkDAO(getDataSource());
    }

    @After
    public void tearDown() throws Exception {
        rollback();
    }
    
    /* Note all test cases below depend on your instance of database */
   
    @Test
    public void getAllParksShouldReturnAListOfAllParks() {
        List<Park> actualResult = parkDAO.getAllParks();
        assertNotNull(actualResult.get(0));
    }
    
    @Test
    public void getParkByParkCodeWillReturnTheCorrespondingPark() {
        String testParkCode = "GNP";
        Park actualResult = parkDAO.getParkByParkCode(testParkCode);
        assertEquals(testParkCode, actualResult.getParkCode());
    }
    
    @Test
    public void getFavoriteParksShouldReturnAListOfFavoriteParks() {
        List<Park> actualResult = parkDAO.getFavoriteParks();
        assertNotNull(actualResult.get(0));
    }

}
