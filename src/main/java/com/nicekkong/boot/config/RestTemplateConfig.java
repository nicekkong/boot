package com.nicekkong.boot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

// https://zepinos.tistory.com/34
// https://sjh836.tistory.com/141
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
@Configuration
public class RestTemplateConfig {

    final private static int ONE_SECONDS = 1000;

    final private ObjectMapper objectMapper;

    final private Logger logger = LoggerFactory.getLogger(this.getClass());


    public RestTemplateConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public RestTemplate myRestTemplate() {

        HttpClient client = HttpClientBuilder.create()
                .setMaxConnTotal(100) // connection pool 적용
                .setMaxConnPerRoute(5) // connection pool 적용
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(ONE_SECONDS * 3);
        factory.setReadTimeout(ONE_SECONDS * 3);
        factory.setHttpClient(client);

        RestTemplate restTemplate = new RestTemplate(factory);

//        RestTemplate restTemplate = new RestTemplateBuilder()
//                .setConnectTimeout(Duration.ofMillis(ONE_SECONDS * 3))
//                .setReadTimeout(Duration.ofMillis(ONE_SECONDS * 3))
//                .build();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter(objectMapper));
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return restTemplate;
    }
}
