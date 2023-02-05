package com.corlan.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private static final String uri = "https://www.googleapis.com";

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(uri)
                .build();
    }

}
