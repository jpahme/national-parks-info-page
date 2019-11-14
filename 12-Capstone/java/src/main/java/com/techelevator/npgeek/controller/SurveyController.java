package com.techelevator.npgeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.IParkDAO;
import com.techelevator.npgeek.model.ISurveyDAO;
import com.techelevator.npgeek.model.Survey;

@Controller
public class SurveyController {

    @Autowired
    private IParkDAO parkDAO;

    @Autowired
    private ISurveyDAO surveyDAO;

    @RequestMapping(path = "/survey", method = RequestMethod.GET)
    public String displaySurveyPage(ModelMap map) {
        map.put("parks", parkDAO.getAllParks());
        if (!map.containsAttribute("survey")) {
            map.addAttribute("survey", new Survey());
        }

        return "surveyPage";
    }

    @RequestMapping(path = "/survey", method = RequestMethod.POST)
    public String submitSurvey(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
            flash.addFlashAttribute("survey", survey);

            return "redirect:/survey";
        }

        surveyDAO.saveSurvey(survey);
        return "redirect:/favoriteparks";
    }

    @RequestMapping(path = "/favoriteparks", method = RequestMethod.GET)
    public String displayFavoriteParks(ModelMap map) {
        map.put("favoriteParks", parkDAO.getFavoriteParks());

        return "favoriteParksPage";
    }

}
