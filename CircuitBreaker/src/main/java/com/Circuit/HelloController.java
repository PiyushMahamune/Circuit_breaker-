package com.Circuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/hello")
    public String hello() {
        return exampleService.hello();
    }
}
