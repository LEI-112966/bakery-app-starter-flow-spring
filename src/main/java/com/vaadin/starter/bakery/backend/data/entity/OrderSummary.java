package com.vaadin.starter.bakery.backend.data.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.vaadin.starter.bakery.backend.data.OrderState;

public interface OrderSummary {
	/**
	 * Returns the order ID.
	 * @return order ID
	 */
	Long getId();

	/**
	 * Returns the order state.
	 * @return order state
	 */
	OrderState getState();

	/**
	 * Returns the customer associated with the order.
	 * @return customer
	 */
	Customer getCustomer();

	/**
	 * Returns the list of items in the order.
	 * @return list of order items
	 */
	List<OrderItem> getItems();

	/**
	 * Returns the due date for the order.
	 * @return due date
	 */
	LocalDate getDueDate();

	/**
	 * Returns the due time for the order.
	 * @return due time
	 */
	LocalTime getDueTime();

	/**
	 * Returns the pickup location for the order.
	 * @return pickup location
	 */
	PickupLocation getPickupLocation();

	/**
	 * Returns the total price for the order.
	 * @return total price
	 */
	Integer getTotalPrice();
}
