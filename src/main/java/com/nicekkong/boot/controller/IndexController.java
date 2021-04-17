package com.nicekkong.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {

        model.addAttribute("name", "nicekkong");
        model.addAttribute("time", LocalDateTime.now());

        return "index";
    }

}
