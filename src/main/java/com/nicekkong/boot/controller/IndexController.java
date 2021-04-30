package com.nicekkong.boot.controller;

import com.nicekkong.boot.domain.TbMember;
import com.nicekkong.boot.repository.TbMemberRepository;
import com.nicekkong.boot.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class IndexController {

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value(value="${email}")
    private String email;

    @Value(value="${default-email}")
    private String defaultEmail;

    private final TbMemberRepository tbMemberRepository;
    private final CacheService cacheService;

    public IndexController(TbMemberRepository tbMemberRepository, CacheService cacheService) {
        this.tbMemberRepository = tbMemberRepository;
        this.cacheService = cacheService;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {

        model.addAttribute("name", "nicekkong");
        model.addAttribute("time", LocalDateTime.now());

        TbMember tbMember = tbMemberRepository.findById(1L).get();
        model.addAttribute("member", tbMember);
        model.addAttribute("email", email);
        model.addAttribute("defaultEmail", defaultEmail);

        logger.trace("trace -- Hello world.");
        logger.debug("debug -- Hello world.");
        logger.info("info -- Hello world.");
        logger.warn("warn -- Hello world.");
        logger.error("error -- Hello world.");


        String test = cacheService.getCache(1);
        logger.debug("test =================> {}", test);

        String test2 = cacheService.getCache(2);
        logger.debug("test =================> {}", test2);

        cacheService.evictCache(1);


        return "index";
    }

}
