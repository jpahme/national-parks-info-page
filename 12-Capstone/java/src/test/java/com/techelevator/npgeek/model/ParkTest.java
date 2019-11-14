package com.techelevator.npgeek.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ParkTest {
    
    private Park park = new Park();

    @Test
    public void testAllSettersAndGetters() {
        int acreage = 1;
        int annualVisitorCount = 1000;
        String climate = "rain";
        int elevationFeet = 300;
        int entryFee = 20;
        String inspirationalQuote = "Dream Bigger";
        String inspirationalQuoteSource = "www.google.com";
        BigDecimal milesOfTrail = BigDecimal.valueOf(20.3);
        int numberOfAnimalSpecies = 120;
        int numberOfCampSites = 3;
        String parkCode = "FNP";
        String parkDescription = "A park full of fakeness";
        String parkName = "Fake National Park";
        String state = "Fake State";
        int yearFounded = 1995;
        int surveyCount = 10;
        
        park.setAcreage(acreage);
        park.setAnnualVisitorCount(annualVisitorCount);
        park.setClimate(climate);
        park.setElevationInFeet(elevationFeet);
        park.setEntryFee(entryFee);
        park.setInspirationalQuote(inspirationalQuote);
        park.setInspirationalQuoteSource(inspirationalQuoteSource);
        park.setMilesOfTrail(milesOfTrail);
        park.setNumberOfAnimalSpecies(numberOfAnimalSpecies);
        park.setNumberOfCampSites(numberOfCampSites);
        park.setParkCode(parkCode);
        park.setParkDescription(parkDescription);
        park.setParkName(parkName);
        park.setState(state);
        park.setYearFounded(yearFounded);
        park.setSurveyCount(surveyCount);
        
        assertEquals(acreage, park.getAcreage());
        assertEquals(annualVisitorCount, park.getAnnualVisitorCount());
        assertEquals(climate, park.getClimate());
        assertEquals(elevationFeet, park.getElevationInFeet());
        assertEquals(entryFee, park.getEntryFee());
        assertEquals(inspirationalQuote, park.getInspirationalQuote());
        assertEquals(inspirationalQuoteSource, park.getInspirationalQuoteSource());
        assertEquals(milesOfTrail, park.getMilesOfTrail());
        assertEquals(numberOfAnimalSpecies, park.getNumberOfAnimalSpecies());
        assertEquals(numberOfCampSites, park.getNumberOfCampSites());
        assertEquals(parkCode, park.getParkCode());
        assertEquals(parkDescription, park.getParkDescription());
        assertEquals(parkName, park.getParkName());
        assertEquals(state, park.getState());
        assertEquals(yearFounded, park.getYearFounded());   
        assertEquals(surveyCount, park.getSurveyCount());
    }

}
