package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements IParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sql = "SELECT * FROM park ORDER BY parkcode";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		
		return allParks;
	}

    @Override
    public Park getParkByParkCode(String parkCode) {
        Park park = new Park();
        String sql = "SELECT * FROM park WHERE parkcode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
        
        while(results.next()) {
            park = mapRowToPark(results);
        }
        
        return park;
    }

    private Park mapRowToPark(SqlRowSet row) {
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
        
        return park;
    }
    
}
