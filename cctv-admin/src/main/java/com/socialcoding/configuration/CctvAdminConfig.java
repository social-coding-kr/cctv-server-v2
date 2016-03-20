package com.socialcoding.configuration;

import com.socialcoding.admin.CctvAdmins;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableSpringDataWebSupport
@ComponentScan(basePackageClasses = { CctvAdmins.class })
public class CctvAdminConfig {
}
