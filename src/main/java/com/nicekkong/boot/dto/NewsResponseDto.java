package com.nicekkong.boot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NewsResponseDto {

    private Integer totalResults;
    private List<Article> articles;
    private String status;

    @Getter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Article {
        private Source source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private static class Source {

        private String id;
        private String name;
    }
}

