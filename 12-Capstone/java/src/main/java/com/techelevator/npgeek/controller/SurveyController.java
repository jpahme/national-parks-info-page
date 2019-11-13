package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.IParkDAO;
import com.techelevator.npgeek.model.Survey;

@Controller
public class SurveyController {
	
	@Autowired
	private IParkDAO parkDAO;

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String displaySurveyPage(ModelMap map) {
		map.put("parks", parkDAO.getAllParks());
		if(!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}
		
		return "surveyPage";
	}
	
	

}
