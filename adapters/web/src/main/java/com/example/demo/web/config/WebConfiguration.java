package com.example.demo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestFactoryConfiguration.class
})
public class WebConfiguration {
}
