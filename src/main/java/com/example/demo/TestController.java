package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/test")
    @Transactional
    public void create() {
        System.out.println("test");
        final Test p = createTest();
        testRepository.save(p);

        final Test p1 = createTest();
        testRepository.save(p1);
        throw new RuntimeException();
    }

    public Test createTest() {
        final Test p = new Test();
        p.setFirstName("firstName");
        return p;
    }

}
