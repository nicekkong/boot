package com.nicekkong.boot.service;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CacheService {

    private static boolean CACHED_BOOL = true;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Cacheable(cacheNames = "getRecordCompleteCache", key="#index")
    public String getCache(int index) {
        logger.info("==========================>FROM METHOD");
        CACHED_BOOL = !CACHED_BOOL;

        return "index:" + index + " called ::: " + (CACHED_BOOL ? "ON" : "OFF");
    }

    @CacheEvict(cacheNames = "getRecordCompleteCache", key="#index")
    public void evictCache(int index) {
        logger.debug("EvictCache ::: {}", index );
    }
}
