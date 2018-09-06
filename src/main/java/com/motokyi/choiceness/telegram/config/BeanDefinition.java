package com.motokyi.choiceness.telegram.config;

import com.motokyi.choiceness.telegram.components.TGRTErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanDefinition {

    @Autowired
    TGRTErrorHandler handler;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(new RestTemplateInterceptor());
        restTemplate.setErrorHandler(handler);
        return restTemplate;
    }
}
