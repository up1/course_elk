package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        return "Hello RESTFul API from Spring boot";
    }

    @GetMapping("/hello-error")
    public String error() {
        try {
            throw new Exception("Error");
        } catch (Exception e) {
            logger.error("error message with stack trace ", e);
        }
        return "Error";
    }

}
