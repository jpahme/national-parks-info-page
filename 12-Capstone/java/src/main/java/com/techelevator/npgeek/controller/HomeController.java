package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.model.IParkDAO;

@Controller
public class HomeController {
	
	@Autowired
	private IParkDAO parkDAO;
	
	@RequestMapping("/")
	public String displayHomePage(ModelMap map) {
		map.put("parks", parkDAO.getAllParks());
		
		return "homePage";
	}

}
