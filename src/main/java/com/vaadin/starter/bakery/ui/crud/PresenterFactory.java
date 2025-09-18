/**
 * Factory for creating presenter beans for CRUD operations.
 */
package com.vaadin.starter.bakery.ui.crud;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.vaadin.starter.bakery.app.security.CurrentUser;
import com.vaadin.starter.bakery.backend.data.entity.Order;
import com.vaadin.starter.bakery.backend.service.OrderService;
import com.vaadin.starter.bakery.ui.views.storefront.StorefrontView;

@Configuration
public class PresenterFactory {

	/**
	 * Creates a prototype-scoped EntityPresenter for Order and StorefrontView.
	 * @param crudService the order service
	 * @param currentUser the current user
	 * @return EntityPresenter instance
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityPresenter<Order, StorefrontView> orderEntityPresenter(OrderService crudService, CurrentUser currentUser) {
		return new EntityPresenter<>(crudService, currentUser);
	}

}
