package com.example.demo.config;

import com.example.demo.persistence.config.PersistenceAdapterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PersistenceAdapterFactory.class
})
public class ApplicationConfig {

}
