package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.IParkDAO;
import com.techelevator.npgeek.model.IWeatherDAO;

@Controller
public class HomeController {
	
	@Autowired
	private IParkDAO parkDAO;
	
	@Autowired
	private IWeatherDAO weatherDAO;
	
	@RequestMapping("/")
	public String displayHomePage(ModelMap map) {
		map.put("parks", parkDAO.getAllParks());
		
		return "homePage";
	}
	
	@RequestMapping("/parkdetail")
	public String displayParkDetail(@RequestParam String parkCode, ModelMap map) {
	    map.put("park", parkDAO.getParkByParkCode(parkCode));
	    map.put("weatherForecast", weatherDAO.getWeatherForecastByParkCode(parkCode));
	    
	    return "parkDetailPage";
	}

}
