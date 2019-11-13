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
    public static void SetUpBeforeClass() throws Exception {
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
    
    @Test
    public void getAllParksShouldReturnAListOfAllParks() {
        List<Park> actualResult = parkDAO.getAllParks();
    }

}
