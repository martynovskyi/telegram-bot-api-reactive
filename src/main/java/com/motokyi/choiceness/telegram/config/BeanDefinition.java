package com.motokyi.choiceness.telegram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanDefinition {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
