package com.techelevator.npgeek.model;

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
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        row.next();
        return row.getInt(1);
    }

}
