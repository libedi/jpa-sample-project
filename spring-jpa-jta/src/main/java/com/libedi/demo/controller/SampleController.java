package com.libedi.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libedi.demo.service.SampleService;

import lombok.RequiredArgsConstructor;

/**
 * SampleController
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService service;

    @PostMapping("/test/{testCase}")
    public void test(@PathVariable("testCase") int i) {
        switch(i) {
            case 1:
                service.allCommit();
                break;
            case 2:
                service.allRollback();
                break;
            case 3:
                service.orderRollback(true);
                break;
            case 4:
                service.customerRollback(true);
                break;
        }
    }

}
