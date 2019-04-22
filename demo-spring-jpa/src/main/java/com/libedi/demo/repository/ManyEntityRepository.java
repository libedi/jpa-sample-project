package com.libedi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libedi.demo.domain.ManyEntity;

/**
 * ManyEntityRepository
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 17
 */
public interface ManyEntityRepository extends JpaRepository<ManyEntity, Long>, ManyEntityRepositoryCustom {

}
