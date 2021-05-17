package com.nicekkong.boot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// https://bamdule.tistory.com/149
@Component
public class RequestInterceptor implements HandlerInterceptor {

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[Request URL] ::: {}", request.getRequestURL());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(response.getStatus() != 200) {
            logger.error("[Response Status] : {} ", response.getStatus());
            ServletOutputStream stream = response.getOutputStream();

            logger.error(stream.toString());
        }
    }
}
