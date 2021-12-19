package com.meeraj.coronavirus.controller;

import com.meeraj.coronavirus.service.VirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoronaVirusDataController {

    @Autowired
    private VirusDataService virusDataService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("locationDatas", virusDataService.getLocationData());
        return "home";
    }
}
