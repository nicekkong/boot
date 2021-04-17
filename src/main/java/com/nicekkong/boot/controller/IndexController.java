package com.nicekkong.boot.controller;

import com.nicekkong.boot.repository.TbMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class IndexController {

    @Autowired
    private TbMemberRepository tbMemberRepository;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {

        model.addAttribute("name", "nicekkong");
        model.addAttribute("time", LocalDateTime.now());


        model.addAttribute("job", tbMemberRepository.findById(1L).get().getTeam());

        return "index";
    }

}
