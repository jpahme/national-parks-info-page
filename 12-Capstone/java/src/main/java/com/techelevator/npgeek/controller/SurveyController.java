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

/**
 * The Class SurveyController.
 */
@Controller
public class SurveyController {

    /** The park DAO. */
    @Autowired
    private IParkDAO parkDAO;

    /** The survey DAO. */
    @Autowired
    private ISurveyDAO surveyDAO;

    /**
     * Display survey page.
     *
     * @param map the map
     * @return the string
     */
    @RequestMapping(path = "/survey", method = RequestMethod.GET)
    public String displaySurveyPage(ModelMap map) {
        map.put("parks", parkDAO.getAllParks());
        if (!map.containsAttribute("survey")) {
            map.addAttribute("survey", new Survey());
        }

        return "surveyPage";
    }

    /**
     * Submit survey.
     *
     * @param survey the survey
     * @param result the result
     * @param flash the flash
     * @return the string
     */
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

    /**
     * Display favorite parks.
     *
     * @param map the map
     * @return the string
     */
    @RequestMapping(path = "/favoriteparks", method = RequestMethod.GET)
    public String displayFavoriteParks(ModelMap map) {
        map.put("favoriteParks", parkDAO.getFavoriteParks());

        return "favoriteParksPage";
    }

}
