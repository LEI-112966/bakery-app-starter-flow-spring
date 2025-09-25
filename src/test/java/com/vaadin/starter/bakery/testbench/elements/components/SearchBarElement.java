package com.vaadin.starter.bakery.testbench.elements.components;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

/**
 * TestBench element representing the search bar component in the UI.
 */
@Element("search-bar")
public class SearchBarElement extends TestBenchElement {

    /**
     * Returns the button element for creating a new item.
     * @return ButtonElement instance
     */
    public ButtonElement getCreateNewButton() {
        return $(ButtonElement.class).id("action");
    }
}
