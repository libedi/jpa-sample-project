package com.libedi.demo.repository.support;

import static com.libedi.demo.domain.QAcademy.academy;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.libedi.demo.domain.Academy;
import com.querydsl.jpa.impl.JPAQueryFactory;;

/**
 * AcademyRepositorySupport
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }

    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

}
