package com.techelevator.npgeek.model;

import java.util.List;

public interface IParkDAO {
	
	public List<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);
	public List<Park> getFavoriteParks();
	
}
