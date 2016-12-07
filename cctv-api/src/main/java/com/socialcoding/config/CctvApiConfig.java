package com.socialcoding.config;

import com.socialcoding.interfaces.api.CctvApis;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { CctvApis.class })
public class CctvApiConfig {
}
