package com.socialcoding.config.oauth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;

//@Configuration
//@EnableOAuth2Client
public class OAuth2Config {

	@Bean
	public FilterRegistrationBean oAuth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(filter);
		registrationBean.setOrder(-100);
		return registrationBean;
	}

	@Bean
	@ConfigurationProperties("facebook")
	public ClientProperties facebookClientResources() {
		return new ClientProperties();
	}

}
