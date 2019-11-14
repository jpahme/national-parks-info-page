package com.techelevator.npgeek.model.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.npgeek.model.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Survey;

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
    
    /* Note all test cases below depend on your instance of database */

    @Test
    public void saveSurveyShouldInsertSurveyIntoDB() {
        Survey testSurvey = new Survey();
        testSurvey.setActivityLevel("inactive");
        testSurvey.setEmailAddress("test@test.test");
        testSurvey.setParkCode("GNP");
        testSurvey.setState("Michigan");
        
        surveyDAO.saveSurvey(testSurvey);
        
        List<Survey> actualResults = surveyDAO.getSurveysByEmailAddress(testSurvey.getEmailAddress());
        
        assertEquals(testSurvey.getEmailAddress(), actualResults.get(0).getEmailAddress());
        assertEquals(testSurvey.getParkCode(), actualResults.get(0).getParkCode());
        assertEquals(testSurvey.getActivityLevel(), actualResults.get(0).getActivityLevel());
        assertEquals(testSurvey.getState(), actualResults.get(0).getState());
        assertNotNull(testSurvey.getSurveyId());
    }

}
