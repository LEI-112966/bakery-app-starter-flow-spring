package com.vaadin.starter.bakery.app.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Utility class for security-related static operations.
 * <p>
 * Provides methods for querying authentication and user details from the security context.
 * </p>
 *
 * @author GitHub Copilot
 */
public final class SecurityUtils {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private SecurityUtils() {
		// Util methods only
	}

	/**
	 * Gets the user name of the currently signed in user.
	 *
	 * @return the user name of the current user or <code>null</code> if the user
	 *         has not signed in
	 */
	public static String getUsername() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null) {
			Object principal = context.getAuthentication().getPrincipal();
			if(principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();
				return userDetails.getUsername();
			}
		}
		// Anonymous or no authentication.
		return null;
	}

	/**
	 * Checks if the user is logged in.
	 *
	 * @return true if the user is logged in. False otherwise.
	 */
	public static boolean isUserLoggedIn() {
		return isUserLoggedIn(SecurityContextHolder.getContext().getAuthentication());
	}

	/**
	 * Checks if the given authentication represents a logged-in user.
	 *
	 * @param authentication the authentication object
	 * @return true if the user is logged in, false otherwise
	 */
	private static boolean isUserLoggedIn(Authentication authentication) {
		return authentication != null
			&& !(authentication instanceof AnonymousAuthenticationToken);
	}

}
