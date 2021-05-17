package com.nicekkong.boot.service;

import com.nicekkong.boot.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public String getMemberNameById(Long id) {

        String name = memberMapper.selectMemberById(id).getName();

        return name;

    }



}
