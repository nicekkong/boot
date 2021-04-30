package com.nicekkong.boot.component;

public interface Weapon {

    default int fire() {
        System.out.println("Default fire()!!");
        return 0;
    };
    default void reload() {
        System.out.println("Default reload()");
    };
}
