package com.vaadin.starter.bakery.ui;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import static com.vaadin.starter.bakery.ui.utils.BakeryConst.VIEWPORT;

/**
 * Configures the application shell for the Bakery App Starter.
 * <p>
 * Sets up viewport, theme, and Progressive Web App (PWA) settings.
 * </p>
 *
 * @author GitHub Copilot
 */
@Viewport(VIEWPORT)
@Theme("bakery")
@PWA(name = "Bakery App Starter", shortName = "###Bakery###",
		startPath = "login",
		backgroundColor = "#227aef", themeColor = "#227aef",
		offlinePath = "offline-page.html",
		offlineResources = {"images/offline-login-banner.jpg"})
public class AppShell implements AppShellConfigurator {
}