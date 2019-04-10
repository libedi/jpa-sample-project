package com.libedi.demo.transform;

import com.libedi.demo.domain.TestEntity;
import com.libedi.demo.dto.TestDto;

/**
 * TestTransformer
 *
 * @author Sang-jun, Park (libedi@linecorp.com)
 * @since 2019. 04. 02
 */
public class TestTransformer {

    /**
     * @param dto
     * @return
     */
    public static TestEntity transform(TestDto dto) {
        return TestEntity.builder()
                .name(dto.getName())
                .enums(dto.getEnums())
                .build();
    }

    public static TestDto transform(TestEntity entity) {
        return TestDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .enums(entity.getEnums())
                .build();
    }

}
