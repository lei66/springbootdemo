package com.example.springbootdemo;

import com.example.springbootdemo.web.News;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
public class Config {

    @Bean
    public News getN() {
        return new News("s");
    }
}
