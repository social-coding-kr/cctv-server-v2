package com.socialcoding.config;


import com.socialcoding.domain.CctvDomains;
import com.socialcoding.domain.base.entity.AuditorInjector;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackageClasses = CctvDomains.class)
@EntityScan(basePackageClasses = { CctvDomains.class, Jsr310Converters.class })
@EnableTransactionManagement
@EnableJpaAuditing
public class CctvJpaRepositoryConfig {

    @Bean
	public AuditorInjector auditorAware() {
    	return new AuditorInjector();
	}

}
