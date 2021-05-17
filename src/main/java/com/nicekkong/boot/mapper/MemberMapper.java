package com.nicekkong.boot.mapper;

import com.nicekkong.boot.domain.TbMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // 실제로는 안 붙여줘도 되나, autowired를 통해 사용시 IDE의 빨간줄을 없애주기 위해...
@Mapper
public interface MemberMapper {

    TbMember selectMemberById(Long id);

    @Select("SELECT * FROM tb_member")
    List<TbMember> selectMembers();

}
