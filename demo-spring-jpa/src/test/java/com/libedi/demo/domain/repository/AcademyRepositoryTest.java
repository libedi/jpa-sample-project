package com.libedi.demo.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.libedi.demo.domain.Academy;
import com.libedi.demo.domain.repository.support.AcademyRepositorySupport;

/**
 * AcademyRepositoryTest
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyRepositoryTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;

    @After
    public void tearDown() {
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void test_querdsl() {
        // given
        String name = "libedi";
        String address = "libedi@gmail.com";
        academyRepository.save(Academy.builder().name(name).address(address).build());

        // when
        List<Academy> result = academyRepositorySupport.findByName(name);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getAddress()).isEqualTo(address);
    }

}
