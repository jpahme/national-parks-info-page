package com.techelevator.npgeek.model;

import java.util.List;

/**
 * The Interface IParkDAO.
 */
public interface IParkDAO {
	
	/**
	 * Gets the all parks.
	 *
	 * @return the all parks
	 */
	public List<Park> getAllParks();
	
	/**
	 * Gets the park by park code.
	 *
	 * @param parkCode the park code
	 * @return the park by park code
	 */
	public Park getParkByParkCode(String parkCode);
	
	/**
	 * Gets the favorite parks.
	 *
	 * @return the favorite parks
	 */
	public List<Park> getFavoriteParks();
	
}
