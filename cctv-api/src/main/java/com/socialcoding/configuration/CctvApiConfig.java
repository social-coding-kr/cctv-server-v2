package com.socialcoding.configuration;

import com.socialcoding.api.CctvApis;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { CctvApis.class })
public class CctvApiConfig {
}
