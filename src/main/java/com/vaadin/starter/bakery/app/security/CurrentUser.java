package com.vaadin.starter.bakery.app.security;

import com.vaadin.starter.bakery.backend.data.entity.User;

/**
 * Provides access to the current authenticated user.
 * <p>
 * Functional interface for retrieving the current {@link User} from the security context.
 * </p>
 *
 * @author GitHub Copilot
 */
@FunctionalInterface
public interface CurrentUser {

	/**
	 * Returns the current authenticated user.
	 *
	 * @return the current {@link User}, or null if not authenticated
	 */
	User getUser();
}
