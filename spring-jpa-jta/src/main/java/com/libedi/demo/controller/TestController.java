package com.libedi.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libedi.demo.service.TestService;

import lombok.RequiredArgsConstructor;

/**
 * TestController
 *
 * @author Sang-jun, Park
 * @since 2019. 09. 10
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

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
