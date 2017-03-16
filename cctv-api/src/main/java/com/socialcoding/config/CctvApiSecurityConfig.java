package com.socialcoding.config;

//@Configuration
public class CctvApiSecurityConfig //extends WebSecurityConfigurerAdapter
{
//
//	@Autowired
//	private OAuth2ClientContext oAuth2ClientContext;
//
//	@Autowired
//	@Qualifier("facebookClientResources")
//	private ClientResources facebookClientResources;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.antMatcher("/**")
//			.authorizeRequests()
//				.antMatchers("/", "/login**").permitAll()
//				.anyRequest().authenticated()
//			.and().exceptionHandling()
//				.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
//			.and().logout()
//				.logoutSuccessUrl("/").permitAll()
//			.and().csrf()
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			.and()
//				.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
//	}
//
//	private Filter ssoFilter() {
//		CompositeFilter filter = new CompositeFilter();
//		List<Filter> filters = new ArrayList<>();
//		filters.add(ssoFilter(facebookClientResources, "/login/facebook"));
//		filter.setFilters(filters);
//		return filter;
//	}
//
//	private Filter ssoFilter(ClientResources client, String path) {
//		OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(path);
//		OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oAuth2ClientContext);
//		filter.setRestTemplate(template);
//		filter.setTokenServices(new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId()));
//		return filter;
//	}

}

