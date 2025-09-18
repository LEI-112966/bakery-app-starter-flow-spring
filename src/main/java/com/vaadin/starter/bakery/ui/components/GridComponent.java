package com.vaadin.starter.bakery.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class GridComponent extends Grid<Integer> {

    /**
     * Constructs a GridComponent with test data and a button column.
     */
    public GridComponent() {
        setItems(0, 1);
        addComponentColumn(i -> createButton(i));
    }

    /**
     * Creates a test button for the given integer value.
     * @param i the integer value
     * @return a Button instance
     */
    private Button createButton(Integer i) {
        return new Button("Test Button " + i, e -> {
            RouteChangingDialog dialog = new RouteChangingDialog();
            dialog.open();
        });
    }

}
