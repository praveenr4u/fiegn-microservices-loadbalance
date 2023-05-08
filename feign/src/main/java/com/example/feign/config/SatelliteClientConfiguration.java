package com.example.feign.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class SatelliteClientConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        BasicAuthRequestInterceptor basicAuthRequestInterceptor = new BasicAuthRequestInterceptor("user", "password");
        return basicAuthRequestInterceptor;
    }
}
