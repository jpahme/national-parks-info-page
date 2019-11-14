package com.techelevator.npgeek.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SurveyTest {

    private Survey survey = new Survey();
    
    @Test
    public void testAllGettersAndSetters() {
        int surveyId = 3;
        String activityLevel = "inactive";
        String emailAddress = "abc@gmail.com";
        String parkCode = "GNP";
        String state = "Michigan";
        
        survey.setActivityLevel(activityLevel);
        survey.setEmailAddress(emailAddress);
        survey.setParkCode(parkCode);
        survey.setState(state);
        survey.setSurveyId(surveyId);
        
        assertEquals(surveyId, survey.getSurveyId());
        assertEquals(activityLevel, survey.getActivityLevel());
        assertEquals(emailAddress, survey.getEmailAddress());
        assertEquals(state, survey.getState());
        assertEquals(parkCode, survey.getParkCode());
    }

}
