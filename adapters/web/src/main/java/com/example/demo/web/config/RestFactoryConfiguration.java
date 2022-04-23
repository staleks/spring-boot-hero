package com.example.demo.web.config;

import com.example.demo.core.geo.CityQuery;
import com.example.demo.core.geo.CountryQuery;
import com.example.demo.core.geo.CreateCountryUseCase;
import com.example.demo.web.endpoint.CityController;
import com.example.demo.web.endpoint.CountryController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class RestFactoryConfiguration {

    private static String[] allowedMethods = {"OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"};
    private static String[] exposedHeaders = {"X-Total", "X-Total-Pages", "X-Page", "X-Size"};

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //
        // config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        for(String allowedMethodItem : allowedMethods) {
            config.addAllowedMethod(allowedMethodItem);
        }
        for(String exposedHeader : exposedHeaders) {
            config.addExposedHeader(exposedHeader);
        }
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /**
     * MessageSource bean to handle i18n support.
     *
     * @return
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public CountryController countryController(final CountryQuery countryQuery,
                                               final CreateCountryUseCase createCountryUseCase) {
        return new CountryController(countryQuery, createCountryUseCase);
    }

    @Bean
    public CityController cityController(final CityQuery cityQuery) {
        return new CityController(cityQuery);
    }


}
