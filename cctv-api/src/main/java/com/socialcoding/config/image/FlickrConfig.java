package com.socialcoding.config.image;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ FlickrProperties.class })
public class FlickrConfig {
}
