package com.rest.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan
@SpringBootApplication
public class NeoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeoApplication.class, args);
    }

}
