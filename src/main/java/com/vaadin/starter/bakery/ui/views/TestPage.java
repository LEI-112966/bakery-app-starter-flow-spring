package com.vaadin.starter.bakery.ui.views;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.bakery.ui.components.GridComponent;

/**
 * Test page for demonstrating the GridComponent in the Bakery application.
 * <p>
 * This view is accessible at the '/test' route and displays a grid component.
 * </p>
 *
 * @author GitHub Copilot
 */
@Route("test")
class TestPage extends VerticalLayout {

    /**
     * Injected grid component to be displayed on the page.
     */
    @Autowired
    private GridComponent grid;

    /**
     * Initializes the view and adds the grid component.
     */
    @PostConstruct
    public void init() {
        add(grid);
    }
}
