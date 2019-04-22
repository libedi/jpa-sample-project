package com.libedi.demo.repository;

import java.util.List;

import com.libedi.demo.domain.ManyEntity;

/**
 * ManyEntityRepositoryCustom
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 17
 */
public interface ManyEntityRepositoryCustom {

    List<ManyEntity> findByOneEntityId(Long id);

    List<ManyEntity> findByOneEntityName(String name);

}
