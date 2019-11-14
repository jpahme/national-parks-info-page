package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.IParkDAO;
import com.techelevator.npgeek.model.IWeatherDAO;

@Controller
public class HomeController {

    @Autowired
    private IParkDAO parkDAO;

    @Autowired
    private IWeatherDAO weatherDAO;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String displayHomePage(ModelMap map) {
        map.put("parks", parkDAO.getAllParks());

        return "homePage";
    }

    @RequestMapping(path = "/parkdetail", method = RequestMethod.GET)
    public String displayParkDetailPage(@RequestParam String parkCode, ModelMap map, HttpSession session) {
        map.put("park", parkDAO.getParkByParkCode(parkCode));
        map.put("weatherForecast", weatherDAO.getWeatherForecastByParkCode(parkCode));

        if (session.getAttribute("temperatureScale") == null) {
            map.put("temperatureScale", "fahrenheit");
        } else {
            map.put("temperatureScale", session.getAttribute("temperatureScale"));
        }

        return "parkDetailPage";
    }

    @RequestMapping(path = "/parkdetail", method = RequestMethod.POST)
    public String convertTemperatures(@RequestParam String temperatureScale, @RequestParam String parkCode,
            HttpSession session) {
        session.setAttribute("temperatureScale", temperatureScale);

        return "redirect:/parkdetail?parkCode=" + parkCode;
    }

}
