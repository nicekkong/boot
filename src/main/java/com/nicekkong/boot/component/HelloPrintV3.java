package com.nicekkong.boot.component;

public class HelloPrintV3 implements HelloPrint {

    @Override
    public void print(String name) {

        System.out.println(name + "V3");
    }
}
