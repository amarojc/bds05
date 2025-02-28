package com.devsuperior.movieflix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private Environment environment;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = {"/oauth/token","/h2-console/**"};
	private static final String[] VISITOR_OR_MEMBER = {"/users/profile", "/movies/**", "/genres/**"};
	private static final String[] MEMBER = {"/reviews/**"};
	

	/**
	 * Configurando as rotas e autorizações de acessos.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		if(Arrays.asList(environment.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, VISITOR_OR_MEMBER).hasAnyRole("VISITOR", "MEMBER")
		.antMatchers(HttpMethod.POST, MEMBER).hasAnyRole("MEMBER")
		.anyRequest().authenticated();
	}
	
	/**
	 * Configuração para decodificar o token e analisar se o token esta batendo com o secret, 
	 * se está expirado, etc, e ter condições de saber se o token é válido 
	 */
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception{
		resources.tokenStore(tokenStore);
	}
	
}
