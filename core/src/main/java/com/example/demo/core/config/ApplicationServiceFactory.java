package com.example.demo.core.config;

import com.example.demo.core.CountryPersistencePort;
import com.example.demo.core.CountryQuery;
import com.example.demo.core.CountryServiceQuery;
import com.example.demo.core.CreateCountryService;
import com.example.demo.core.CreateCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceFactory {

    @Bean
    CountryQuery countryQuery(final CountryPersistencePort countryPersistencePort) {
        return new CountryServiceQuery(countryPersistencePort);
    }

    @Bean
    CreateCountryUseCase createCountryUseCase(final CountryPersistencePort countryPersistencePort) {
        return new CreateCountryService(countryPersistencePort);
    }

}
