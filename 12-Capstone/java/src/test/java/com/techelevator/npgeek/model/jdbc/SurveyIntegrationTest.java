package com.techelevator.npgeek.model.jdbc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.npgeek.model.JDBCParkDAO;
import com.techelevator.npgeek.model.JDBCSurveyDAO;

public class SurveyIntegrationTest extends DAOIntegrationTest {
	
	private JDBCSurveyDAO surveyDAO;
	
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
        surveyDAO = new JDBCSurveyDAO(getDataSource());
    }

    @After
    public void tearDown() throws Exception {
        rollback();
    }
    
    @Test 
    public void saveSurveyReturnsTheCorrespondingSurvey() {
    	
    }
    

}
