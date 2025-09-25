package com.vaadin.starter.bakery.testbench;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.starter.bakery.testbench.elements.ui.DashboardViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.LoginViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.StorefrontViewElement;

/**
 * Integration tests for login and logout functionality.
 */
public class LoginIT extends AbstractIT<LoginViewElement> {

	/**
	 * Tests that login works with valid credentials.
	 */
	@Test
	public void loginWorks() {
		LoginViewElement loginView = openLoginView();
		assertEquals("Email", loginView.getUsernameLabel());
		loginView.login("barista@vaadin.com", "barista");
	}

	/**
	 * Tests that logout works and redirects to login page.
	 */
	@Test
	public void logout() {
		LoginViewElement loginView = openLoginView();
		StorefrontViewElement storefront = loginView.login("barista@vaadin.com", "barista");
		storefront.getMenu().logout();
		Assert.assertTrue(getDriver().getCurrentUrl().endsWith("login"));
	}

	/**
	 * Tests login to a non-default URL and verifies dashboard access.
	 */
	@Test
	public void loginToNotDefaultUrl() {
		LoginViewElement loginView = openLoginView(getDriver(), APP_URL + "dashboard");
		DashboardViewElement dashboard = loginView.login("admin@vaadin.com", "admin", DashboardViewElement.class);
		Assert.assertNotNull(dashboard);
	}

	/**
	 * Tests that navigating to /login after login redirects to storefront.
	 */
	@Test
	public void openLoginAfterLoggedIn() {
		loginToNotDefaultUrl();
		// Navigating to /login after user is logged in will forward to storefront view
		driver.get(APP_URL + "login");
		$(StorefrontViewElement.class).onPage().waitForFirst();
		Assert.assertTrue($(LoginViewElement.class).all().isEmpty());
	}

	/**
	 * Opens the Login view.
	 * @return LoginViewElement instance
	 */
	@Override
	protected LoginViewElement openView() {
		return openLoginView();
	}

}