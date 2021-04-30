package com.nicekkong.boot.config;

import com.nicekkong.boot.component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class HelloConfig {

    private final Weapon m16;

    public HelloConfig(Weapon m16) {
        this.m16 = m16;
    }

    @Bean
    public Hello helloV2(@Qualifier("helloPrintV2")HelloPrint helloPrintV2) {
        Hello hello = new Hello();

        hello.setName("wonwoo" + m16.fire() + ";;;");
        hello.print(helloPrintV2);


        return hello;
    }

    @Bean
    public Hello helloV3(@Qualifier("helloPrintV3") HelloPrint helloPrintV3) {
        Hello hello = new Hello();

        hello.setName("wonwoo" + m16.fire() + ";;;");
        hello.print(helloPrintV3);


        return hello;
    }

//    @Bean
//    public HelloPrint helloPrint() {
//        return new HelloPrint();
//    }

    @Bean(name="helloPrintV2")
    public HelloPrint HelloPrintV2() {
        return new HelloPrintV2();
    }

    @Bean(name="helloPrintV3")
    public HelloPrint HelloPrintV3() {
        return new HelloPrintV3();
    }
}