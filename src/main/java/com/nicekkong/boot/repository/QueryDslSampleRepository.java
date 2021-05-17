package com.nicekkong.boot.repository;

import com.nicekkong.boot.domain.QTbMember;
import com.nicekkong.boot.domain.TbMember;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class QueryDslSampleRepository {

    private final JPAQueryFactory query;

    public QueryDslSampleRepository(JPAQueryFactory query) {
        this.query = query;
    }

    public List<TbMember> getMemberList() {

        QTbMember member = QTbMember.tbMember;

        List<TbMember> members = query
                .select(member)
                .from(member).fetch();
        return members;
    }
}
