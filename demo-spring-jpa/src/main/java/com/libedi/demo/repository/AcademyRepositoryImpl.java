package com.libedi.demo.repository;

import static com.libedi.demo.domain.QAcademy.academy;

import java.util.List;

import com.libedi.demo.domain.Academy;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * AcademyRepositoryImpl
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

}
