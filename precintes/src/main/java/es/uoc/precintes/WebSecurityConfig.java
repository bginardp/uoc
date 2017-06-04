
package es.uoc.precintes;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * 
 * @author BERNAT1
 * Configuració de la seguretat de Spring
 * Totes les peticions cap a recursos de admin han de tenir el rol ADMIN
 * Els usuaris que poden entrar a l'aplicació són user i admin
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error").permitAll().and()
		.logout().permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER").and().withUser("user")
				.password("user").roles("USER");
	}

}