package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * The Class JDBCParkDAO.
 */
@Component
public class JDBCParkDAO implements IParkDAO {
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Instantiates a new JDBC park DAO.
	 *
	 * @param dataSource the data source
	 */
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Gets the all parks.
	 *
	 * @return the all parks
	 */
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sql = "SELECT * FROM park ORDER BY parkcode";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			allParks.add(mapRowToPark(results, false));
		}
		
		return allParks;
	}

    /**
     * Gets the park by park code.
     *
     * @param parkCode the park code
     * @return the park by park code
     */
    @Override
    public Park getParkByParkCode(String parkCode) {
        Park park = new Park();
        String sql = "SELECT * FROM park WHERE parkcode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
        
        while(results.next()) {
            park = mapRowToPark(results, false);
        }
        
        return park;
    }
    
    /**
     * Gets the favorite parks.
     *
     * @return the favorite parks
     */
    @Override
    public List<Park> getFavoriteParks() {
        List<Park> favoriteParks = new ArrayList<>();
        String sql = "SELECT park.*, surveycount \r\n" + 
                "FROM park INNER JOIN\r\n" + 
                "(SELECT park.parkcode, \r\n" + 
                "COUNT(surveyid) surveycount\r\n" + 
                "FROM park INNER JOIN\r\n" + 
                "survey_result survey\r\n" + 
                "ON park.parkcode = survey.parkcode\r\n" + 
                "GROUP BY park.parkcode) t\r\n" + 
                "ON park.parkcode = t.parkcode\r\n" + 
                "ORDER BY surveycount DESC, parkcode";
        
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        
        while(results.next()) {
            favoriteParks.add(mapRowToPark(results, true));
        }
        
        return favoriteParks;
    }
    
    /**
     * Map row to park.
     *
     * @param row the row
     * @param hasSurveyCount the has survey count
     * @return the park
     */
    private Park mapRowToPark(SqlRowSet row, boolean hasSurveyCount) {
        Park park = new Park();
        
        park.setAcreage(row.getInt("acreage"));
        park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
        park.setClimate(row.getString("climate"));
        park.setElevationInFeet(row.getInt("elevationinfeet"));
        park.setEntryFee(row.getInt("entryfee"));
        park.setInspirationalQuote(row.getString("inspirationalquote"));
        park.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
        park.setMilesOfTrail(row.getBigDecimal("milesoftrail"));
        park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
        park.setNumberOfCampSites(row.getInt("numberofcampsites"));
        park.setParkCode(row.getString("parkcode"));
        park.setParkDescription(row.getString("parkdescription"));
        park.setParkName(row.getString("parkname"));
        park.setState(row.getString("state"));
        park.setYearFounded(row.getInt("yearfounded"));
        
        if (hasSurveyCount) {
            park.setSurveyCount(row.getInt("surveycount"));
        }
        
        return park;
    }

}
