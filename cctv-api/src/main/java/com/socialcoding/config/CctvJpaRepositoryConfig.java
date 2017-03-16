package com.socialcoding.config;


import com.socialcoding.domain.CctvDomains;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackageClasses = { CctvDomains.class })
@EntityScan(basePackageClasses = { CctvDomains.class, Jsr310JpaConverters.class })
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorInjector")
public class CctvJpaRepositoryConfig {
}
