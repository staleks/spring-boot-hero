package com.example.demo.persistence.config;

import com.example.demo.core.CountryPersistencePort;
import com.example.demo.persistence.adapter.geo.CountryPersistenceAdapter;
import com.example.demo.persistence.repository.geo.JpaCountryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PersistenceConfig.class
})
public class PersistenceAdapterFactory {
    @Bean
    public CountryPersistencePort countryPersistencePort(final JpaCountryRepository jpaCountryRepository) {
        return new CountryPersistenceAdapter(jpaCountryRepository);
    }

}
