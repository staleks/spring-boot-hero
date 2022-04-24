package com.example.demo.persistence.config;

import com.example.demo.core.cms.PostCommentPersistencePort;
import com.example.demo.core.cms.PostPersistencePort;
import com.example.demo.core.geo.CityPersistencePort;
import com.example.demo.core.geo.CountryPersistencePort;
import com.example.demo.persistence.cms.adapter.PostCommentPersistenceAdapter;
import com.example.demo.persistence.cms.adapter.PostPersistenceAdapter;
import com.example.demo.persistence.cms.repository.JpaPostCommentRepository;
import com.example.demo.persistence.cms.repository.JpaPostRepository;
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

    @Bean
    public PostPersistencePort postPersistencePort(final JpaPostRepository jpaPostRepository) {
        return new PostPersistenceAdapter(jpaPostRepository);
    }

    @Bean
    public PostCommentPersistencePort postCommentPersistencePort(final JpaPostCommentRepository jpaPostCommentRepository) {
        return new PostCommentPersistenceAdapter(jpaPostCommentRepository);
    }

}
