package com.example.demo.config;

import com.example.demo.core.config.ApplicationServiceFactory;
import com.example.demo.persistence.config.PersistenceAdapterFactory;
import com.example.demo.web.config.WebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        WebConfiguration.class,
        ApplicationServiceFactory.class,
        PersistenceAdapterFactory.class
})
public class ApplicationConfig {

}
