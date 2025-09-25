package com.vaadin.starter.bakery.testbench;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.starter.bakery.testbench.elements.components.DashboardLCounterLabelElement;
import com.vaadin.starter.bakery.testbench.elements.ui.DashboardViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.StorefrontViewElement;

/**
 * Integration tests for the Dashboard view, focusing on board and counter features.
 */
public class DashboardViewIT extends AbstractIT<DashboardViewElement> {

	/**
	 * Opens the Dashboard view after logging in as admin.
	 * @return DashboardViewElement instance
	 */
	@Override
	protected DashboardViewElement openView() {
		StorefrontViewElement storefront = openLoginView().login("admin@vaadin.com", "admin");
		return storefront.getMenu().navigateToDashboard();
	}

	/**
	 * Tests that the dashboard board has the expected number of rows.
	 */
	@Test
	public void checkRowsCount() {
		DashboardViewElement dashboardPage = openView();
		Assert.assertEquals(4, dashboardPage.getBoard().getRows().size());
	}

	/**
	 * Tests that the dashboard counters are displayed correctly.
	 */
	@Test
	public void checkCounters() {
		DashboardViewElement dashboardPage = openView();
		int numLabels = dashboardPage.getBoard().getRows().get(0).$(DashboardLCounterLabelElement.class).all().size();
		Assert.assertEquals(4, numLabels);
	}

}
