package org.zeos.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zeos.cafe.service.CafeService;

/**
 * Created by alxev on 09.07.2017.
 */
@Controller
@RequestMapping("/")
public class RootController {
    @Autowired
    private CafeService cafeService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewMainPage(Model model){
        model.addAttribute("area", cafeService.findAllArea());
        model.addAttribute("table", cafeService.findAllTable1());
        return "main";
    }
}
