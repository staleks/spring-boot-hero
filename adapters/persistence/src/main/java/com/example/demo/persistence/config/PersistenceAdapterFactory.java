package com.example.demo.persistence.config;

import com.example.demo.core.geo.CityPersistencePort;
import com.example.demo.core.geo.CountryPersistencePort;
import com.example.demo.persistence.geo.adapter.CityPersistenceAdapter;
import com.example.demo.persistence.geo.adapter.CountryPersistenceAdapter;
import com.example.demo.persistence.geo.repository.JpaCityRepository;
import com.example.demo.persistence.geo.repository.JpaCountryRepository;
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

    @Bean
    public CityPersistencePort cityPersistencePort(final JpaCountryRepository jpaCountryRepository, final JpaCityRepository jpaCityRepository) {
        return new CityPersistenceAdapter(jpaCountryRepository, jpaCityRepository);
    }

}
