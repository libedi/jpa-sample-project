package com.libedi.demo.repository;

import java.util.List;

import com.libedi.demo.domain.ManyEntity;
import com.libedi.demo.domain.QManyEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * ManyEntityRepositoryImpl
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 17
 */
@RequiredArgsConstructor
public class ManyEntityRepositoryImpl implements ManyEntityRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ManyEntity> findByOneEntityId(Long id) {
        final QManyEntity qManyEntity = QManyEntity.manyEntity;
        return queryFactory.selectFrom(qManyEntity)
                .where(qManyEntity.one.oneId.eq(id))
                .fetch();
    }

    @Override
    public List<ManyEntity> findByOneEntityName(String name) {
        final QManyEntity qManyEntity = QManyEntity.manyEntity;
        return queryFactory.selectFrom(qManyEntity)
                .where(qManyEntity.one.oneName.eq(name))
                .fetch();
    }

}
