package com.nicekkong.boot.controller;

import com.nicekkong.boot.component.*;
import com.nicekkong.boot.dto.NewsResponseDto;
import com.nicekkong.boot.repository.QueryDslSampleRepository;
import com.nicekkong.boot.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin
@RequestMapping(value ="/api")
public class SampleRestController {

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    final private RestTemplate myRestTemplate;


    final private MyName nicekkongName;

    final private Weapon m16;

    final private MemberService memberService;

    final private QueryDslSampleRepository sampleRepository;

    final private Hello helloV3;

    @Autowired
    private HelloPrint helloPrintV3;

    public SampleRestController(RestTemplate myRestTemplate, MyName nicekkongName, Weapon m16, MemberService memberService, QueryDslSampleRepository sampleRepository, Hello helloV3) {
        this.myRestTemplate = myRestTemplate;
        this.nicekkongName = nicekkongName;
        this.m16 = m16;
        this.memberService = memberService;
        this.sampleRepository = sampleRepository;
        this.helloV3 = helloV3;
    }

    @GetMapping(value = "/sample")
    public ResponseEntity<NewsResponseDto> getNewsApi() {


        Map<String, String> param = new HashMap<>();

        param.put("date", "2021-04-25");
        param.put("app_key", "49923af7fcb04b6ba1eedb970d526e70");

        // Header 없이 설정
        /*
        ResponseEntity<NewsResponseDto> newsResponseDto = myRestTemplate.getForEntity(
                "https://newsapi.org/v2/everything?q=tesla&from={date}&sortBy=publishedAt&apiKey={app_key}",
                NewsResponseDto.class,
                param);
        */

        // Header 값 설정
        final HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "my-client");

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<NewsResponseDto> newsResponseDto = myRestTemplate.exchange("https://newsapi.org/v2/everything?q=tesla&from={date}&sortBy=publishedAt&apiKey={app_key}",
                HttpMethod.GET, entity, NewsResponseDto.class,
                param);


        logger.debug("TotalResults ::: {}", newsResponseDto.getBody().getTotalResults());

        AtomicInteger num = new AtomicInteger(10);
        newsResponseDto.getBody().getArticles().forEach(article -> {
            System.out.println(num.getAndIncrement() + "_____" + article.getTitle());

        });



        m16.fire();
        m16.reload();

        helloV3.print(helloPrintV3);


        System.out.println(memberService.getMemberNameById(1L)) ;


        sampleRepository.getMemberList().forEach(m -> {
            System.out.println(m.getName() + ":::" + m.getTeam());
        });

        return ResponseEntity.ok().body(newsResponseDto).getBody();



    }



}
