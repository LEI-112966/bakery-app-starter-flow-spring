package com.vaadin.starter.bakery.ui.views.storefront;

import static com.vaadin.starter.bakery.ui.utils.FormattingUtils.HOUR_FORMATTER;
import static com.vaadin.starter.bakery.ui.utils.FormattingUtils.MONTH_AND_DAY_FORMATTER;
import static com.vaadin.starter.bakery.ui.utils.FormattingUtils.SHORT_DAY_FORMATTER;
import static com.vaadin.starter.bakery.ui.utils.FormattingUtils.WEEKDAY_FULLNAME_FORMATTER;
import static com.vaadin.starter.bakery.ui.utils.FormattingUtils.WEEK_OF_YEAR_FIELD;

import java.time.LocalDate;
import java.util.List;

import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.starter.bakery.backend.data.entity.Order;
import com.vaadin.starter.bakery.backend.data.entity.OrderItem;
import com.vaadin.starter.bakery.backend.data.entity.OrderSummary;

/**
 * Utility class for rendering order cards in the Storefront and Dashboard grids.
 * <p>
 * Uses LitRenderer for efficient rendering and supports optional headers for visual grouping.
 * </p>
 *
 * @author GitHub Copilot
 */
public class OrderCard {

	/**
	 * Returns a LitRenderer template for displaying an order card.
	 *
	 * @return LitRenderer template
	 */
	public static LitRenderer<Order> getTemplate() {
		return LitRenderer.of(
				  "<order-card"
				+ "  .header='${item.header}'"
				+ "  .orderCard='${item.orderCard}'"
				+ "  @card-click='${cardClick}'>"
				+ "</order-card>");
	}
	
	/**
	 * Creates an OrderCard instance from an OrderSummary.
	 *
	 * @param order the order summary
	 * @return OrderCard instance
	 */
	public static OrderCard create(OrderSummary order) {
		return new OrderCard(order);
	}

	private boolean recent, inWeek;
	private final OrderSummary order;
	
	/**
	 * Constructs an OrderCard for the given order summary.
	 *
	 * @param order the order summary
	 */
	public OrderCard(OrderSummary order) {
		this.order = order;
		LocalDate now = LocalDate.now();
		LocalDate date = order.getDueDate();
		recent = date.equals(now) || date.equals(now.minusDays(1));
		inWeek = !recent && now.getYear() == date.getYear() && now.get(WEEK_OF_YEAR_FIELD) == date.get(WEEK_OF_YEAR_FIELD);
	}

	public String getPlace() {
		return recent || inWeek ? order.getPickupLocation().getName() : null;
	}

	public String getTime() {
		return recent ? HOUR_FORMATTER.format(order.getDueTime()) : null;
	}

	public String getShortDay() {
		return inWeek ? SHORT_DAY_FORMATTER.format(order.getDueDate()) : null;
	}

	public String getSecondaryTime() {
		return inWeek ? HOUR_FORMATTER.format(order.getDueTime()) : null;
	}

	public String getMonth() {
		return recent || inWeek ? null : MONTH_AND_DAY_FORMATTER.format(order.getDueDate());
	}

	public String getFullDay() {
		return recent || inWeek ? null : WEEKDAY_FULLNAME_FORMATTER.format(order.getDueDate());
	}

	public String getState() {
		return order.getState().toString();
	}

	public String getFullName() {
		return order.getCustomer().getFullName();
	}

	public List<OrderItem> getItems() {
		return order.getItems();
	}
}
