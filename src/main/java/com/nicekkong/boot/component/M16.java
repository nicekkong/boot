package com.nicekkong.boot.component;

import org.springframework.stereotype.Component;

// https://mangkyu.tistory.com/75
@Component
public class M16 implements Weapon {

    private final int bullets = 777;

    @Override
    public int fire() {
        System.out.println("M16 빵빵빵");
        System.out.println(bullets);

        return bullets;
    }

    @Override
    public void reload() {
        System.out.println("M16 장전~!!!");
    }
}
