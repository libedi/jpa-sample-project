package com.libedi.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.libedi.demo.domain.ManyEntity;
import com.libedi.demo.domain.OneEntity;

/**
 * ManyEntityRepositoryTest
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyEntityRepositoryTest {

    @Autowired
    private ManyEntityRepository manyEntityRepository;

    @Autowired
    private OneEntityRepository oneEntityRepository;

    @Before
    public void init() {
        OneEntity one = oneEntityRepository.saveAndFlush(OneEntity.builder().oneName("one name").build());
        OneEntity two = oneEntityRepository.saveAndFlush(OneEntity.builder().oneName("two name").build());
        manyEntityRepository.saveAndFlush(ManyEntity.builder().name("many name1").one(one).build());
        manyEntityRepository.saveAndFlush(ManyEntity.builder().name("many name2").one(one).build());
        manyEntityRepository.saveAndFlush(ManyEntity.builder().name("many name3").one(one).build());
        manyEntityRepository.saveAndFlush(ManyEntity.builder().name("many name4").one(two).build());
    }

//    @Test
    public void test1() {
        // given
        Long id = 1L;

        // when
        List<ManyEntity> actual = manyEntityRepository.findByOneEntityId(id);

        // then
        assertThat(actual).isNotNull();
        if(CollectionUtils.isEmpty(actual) == false) {
            actual.forEach(m -> System.out.println(m.toString()));
        }
    }

    @Test
    public void test2() {
        // given
        String name = "one name";

        // when
        List<ManyEntity> actual = manyEntityRepository.findByOneEntityName(name);

        // then
        assertThat(actual).isNotNull();
        if(CollectionUtils.isEmpty(actual) == false) {
            actual.forEach(m -> System.out.println(m.toString()));
        }
    }
}
