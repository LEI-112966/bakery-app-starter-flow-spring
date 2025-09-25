package com.vaadin.starter.bakery.testbench.elements.ui;

import com.vaadin.flow.component.applayout.testbench.AppLayoutElement;
import com.vaadin.starter.bakery.testbench.elements.components.AppNavigationElement;

/**
 * TestBench element representing the main application layout (AppLayout).
 */
public class MainViewElement extends AppLayoutElement {

	/**
	 * Returns the navigation menu element.
	 * @return AppNavigationElement instance
	 */
	public AppNavigationElement getMenu() {
		return $(AppNavigationElement.class).first();
	}

}
