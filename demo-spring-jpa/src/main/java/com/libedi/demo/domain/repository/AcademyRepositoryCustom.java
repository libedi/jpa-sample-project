package com.libedi.demo.domain.repository;

import java.util.List;

import com.libedi.demo.domain.Academy;

/**
 * AcademyRepositoryCustom
 * <pre>
 * QuerydslSupport 클래스로 분리되는 것을 합치기 위한 Custom Repository
 * </pre>
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
public interface AcademyRepositoryCustom {

    List<Academy> findByName(String name);

}
