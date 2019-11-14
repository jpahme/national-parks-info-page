package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements ISurveyDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public JDBCSurveyDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveSurvey(Survey survey) {
        String sql = "INSERT INTO survey_result "
                + "(surveyid, parkcode, emailaddress, state, activitylevel) "
                + "VALUES (?, ?, ?, ?, ?)";
        int surveyId = getNextSurveyId();
        
        survey.setSurveyId(surveyId);
        
        jdbcTemplate.update(sql, 
                            survey.getSurveyId(), 
                            survey.getParkCode(), 
                            survey.getEmailAddress(),
                            survey.getState(),
                            survey.getActivityLevel());
    }
    
    private int getNextSurveyId() {
        String sql = "SELECT NEXTVAL('seq_surveyid')";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        results.next();
        
        return results.getInt(1);
    }

    /* For Testing Purpose */
    public List<Survey> getSurveysByEmailAddress(String emailAddress) {
        List<Survey> surveys = new ArrayList<>();
        String sql = "SELECT * FROM survey_result WHERE emailaddress = ?";
        
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, emailAddress);
        while(results.next()) {
            surveys.add(mapRowToSurvey(results));
        }
        
        return surveys;
    }
    
    /* For Testing Purpose */
    private Survey mapRowToSurvey(SqlRowSet row) {
        Survey survey = new Survey();
        
        survey.setActivityLevel(row.getString("activitylevel"));
        survey.setEmailAddress(row.getString("emailaddress"));
        survey.setParkCode(row.getString("parkcode"));
        survey.setState(row.getString("state"));
        survey.setSurveyId(row.getInt("surveyid"));
        
        return survey;
    }
    
}
