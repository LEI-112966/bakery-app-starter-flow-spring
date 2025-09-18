package com.vaadin.starter.bakery.ui.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class RouteChangingDialog extends Dialog {
    /**
     * Constructs a dialog that changes the browser route when opened and provides a back button.
     */
    public RouteChangingDialog() {
        Button backButton = new Button("Back", e -> {
            UI.getCurrent().getPage().getHistory().back();
            close();
        });
        add(backButton);

        addOpenedChangeListener(e -> {
            if (isOpened())
                UI.getCurrent().getPage().getHistory().pushState(null, "home");
        });
    }
}