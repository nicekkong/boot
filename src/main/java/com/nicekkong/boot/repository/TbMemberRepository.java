package com.nicekkong.boot.repository;

import com.nicekkong.boot.domain.TbMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TbMemberRepository extends JpaRepository<TbMember, Long> {


}

