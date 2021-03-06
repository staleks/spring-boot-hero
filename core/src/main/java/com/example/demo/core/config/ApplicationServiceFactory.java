package com.example.demo.core.config;

import com.example.demo.core.geo.CityPersistencePort;
import com.example.demo.core.geo.CityQuery;
import com.example.demo.core.geo.CityServiceQuery;
import com.example.demo.core.geo.CountryPersistencePort;
import com.example.demo.core.geo.CountryQuery;
import com.example.demo.core.geo.CountryServiceQuery;
import com.example.demo.core.geo.CreateCountryService;
import com.example.demo.core.geo.CreateCountryUseCase;
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

    @Bean
    CityQuery cityQuery(final CityPersistencePort cityPersistencePort) {
        return new CityServiceQuery(cityPersistencePort);
    }

}
