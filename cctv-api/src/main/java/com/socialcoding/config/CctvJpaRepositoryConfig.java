package com.socialcoding.config;


import com.socialcoding.domain.CctvDomains;
import com.socialcoding.domain.base.entity.AuditorInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
@EntityScan(basePackageClasses = { CctvDomains.class, Jsr310Converters.class })
public class CctvJpaRepositoryConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        jpaTransactionManager.setDataSource(dataSource);
        return jpaTransactionManager;
    }

    @Bean
	public AuditorInjector auditorAware() {
    	return new AuditorInjector();
	}

}
