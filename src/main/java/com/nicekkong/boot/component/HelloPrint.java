package com.nicekkong.boot.component;

public interface HelloPrint {
    default void print(String name) {
        System.out.println(name);
    }
}

