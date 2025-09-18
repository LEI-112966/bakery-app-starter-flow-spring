package com.vaadin.starter.bakery.app.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.UserRepository;

/**
 * Implements the {@link UserDetailsService} for authentication.
 * <p>
 * Searches for {@link User} entities by e-mail address and returns a Spring Security UserDetails object.
 * </p>
 *
 * @author GitHub Copilot
 */
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * Repository for accessing user data.
	 */
	private final UserRepository userRepository;

	/**
	 * Constructs the service with the given user repository.
	 *
	 * @param userRepository Repository for user entities
	 */
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Loads the user by e-mail address for authentication.
	 *
	 * @param username User's e-mail address
	 * @return UserDetails for authentication
	 * @throws UsernameNotFoundException if no user is found
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailIgnoreCase(username);
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(),
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
		}
	}
}