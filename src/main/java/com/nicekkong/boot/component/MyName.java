package com.nicekkong.boot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyName {

    private String name;

    public String myName(String myName) {
        this.name = myName;
        return name + "님입니다.";
    }

    public String nicekkongName() {

        this.name = "NICEKKONG";
//        return name + "님 환영합니다~!!";
        return this.name;
    }
}
