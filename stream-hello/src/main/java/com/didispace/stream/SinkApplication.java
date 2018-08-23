package com.didispace.stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SinkApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SinkApplication.class).web(true).run(args);
        //SpringApplication.run(SinkApplication.class, args);
    }
}