package com.nicekkong.boot.repository;

import com.nicekkong.boot.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "local")

public class RepositoryTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testRepo() {


        String name = memberMapper.selectMemberById(1L).getName();

        System.out.println("name ::: " + name);
        System.out.println("===================================");
        memberMapper.selectMembers().forEach(m -> {
            System.out.println(m.getEmpNo() + " :::: " + m.getName());
        });

    }
}
