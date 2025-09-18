package com.vaadin.starter.bakery.app.security;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.UserRepository;
import com.vaadin.starter.bakery.ui.views.login.LoginView;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configures Spring Security for the Bakery application.
 * <p>
 * This configuration:
 * <ul>
 *   <li>Bypasses security checks for static resources</li>
 *   <li>Restricts access to the application, allowing only logged-in users</li>
 *   <li>Sets up the login form</li>
 *   <li>Configures the {@link UserDetailsServiceImpl}</li>
 * </ul>
 *
 * @author GitHub Copilot
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurityConfigurerAdapter {

	/**
	 * The password encoder to use when encrypting passwords.
	 *
	 * @return a BCrypt password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Provides the current user from the security context.
	 *
	 * @param userRepository the user repository
	 * @return the current user
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CurrentUser currentUser(UserRepository userRepository) {
		final String username = SecurityUtils.getUsername();
		User user = username != null ? userRepository.findByEmailIgnoreCase(username) : null;
		return () -> user;
	}	

	/**
	 * Requires login to access internal pages and configures the login form.
	 *
	 * @param http the HTTP security configuration
	 * @throws Exception if an error occurs
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	/**
	 * Allows access to static resources, bypassing Spring security.
	 * 
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring().antMatchers(
				// the robots exclusion standard
				"/robots.txt",

				// icons and images
				"/icons/**", "/images/**",

				// (development mode) H2 debugging console
				"/h2-console/**");
	}
}
