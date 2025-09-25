package com.vaadin.starter.bakery.testbench.elements.ui;

import com.vaadin.flow.component.board.testbench.BoardElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

/**
 * TestBench element representing the dashboard view in the UI.
 */
@Element("dashboard-view")
public class DashboardViewElement extends TestBenchElement implements HasApp {

	/**
	 * Returns the board element of the dashboard.
	 * @return BoardElement instance
	 */
	public BoardElement getBoard() {
		return $(BoardElement.class).first();
	}

}
