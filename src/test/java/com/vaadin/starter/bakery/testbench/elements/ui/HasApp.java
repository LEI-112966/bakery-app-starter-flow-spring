package com.vaadin.starter.bakery.testbench.elements.ui;

import com.vaadin.starter.bakery.testbench.elements.components.AppNavigationElement;
import com.vaadin.testbench.HasElementQuery;

/**
 * Interface for UI elements that provide access to the main application layout and navigation menu.
 */
public interface HasApp extends HasElementQuery {

	/**
	 * Returns the main application view element.
	 * @return MainViewElement instance
	 */
	default MainViewElement getApp() {
		return $(MainViewElement.class).onPage().first();
	}

	/**
	 * Returns the navigation menu element.
	 * @return AppNavigationElement instance
	 */
	default AppNavigationElement getMenu() {
		return getApp().getMenu();
	}

}
