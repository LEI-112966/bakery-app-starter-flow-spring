package com.vaadin.starter.bakery.backend.repositories;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vaadin.starter.bakery.backend.data.OrderState;
import com.vaadin.starter.bakery.backend.data.entity.Order;
import com.vaadin.starter.bakery.backend.data.entity.OrderSummary;

public interface OrderRepository extends JpaRepository<Order, Long> {

	/**
	 * Finds orders with due date after the specified date.
	 *
	 * @param filterDate the date to filter
	 * @param pageable   pagination information
	 * @return page of matching orders
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	Page<Order> findByDueDateAfter(LocalDate filterDate, Pageable pageable);

	/**
	 * Finds orders by customer name (case-insensitive).
	 *
	 * @param searchQuery the customer name filter
	 * @param pageable    pagination information
	 * @return page of matching orders
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	Page<Order> findByCustomerFullNameContainingIgnoreCase(String searchQuery, Pageable pageable);

	/**
	 * Finds orders by customer name and due date after the specified date.
	 *
	 * @param searchQuery the customer name filter
	 * @param dueDate     the due date filter
	 * @param pageable    pagination information
	 * @return page of matching orders
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	Page<Order> findByCustomerFullNameContainingIgnoreCaseAndDueDateAfter(String searchQuery, LocalDate dueDate, Pageable pageable);

	@Override
	/**
	 * Finds all orders.
	 *
	 * @return list of all orders
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	List<Order> findAll();

	@Override
	/**
	 * Finds all orders with pagination.
	 *
	 * @param pageable pagination information
	 * @return page of all orders
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	Page<Order> findAll(Pageable pageable);

	/**
	 * Finds order summaries with due date greater than or equal to the specified date.
	 *
	 * @param dueDate the due date filter
	 * @return list of order summaries
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_BRIEF, type = EntityGraphType.LOAD)
	List<OrderSummary> findByDueDateGreaterThanEqual(LocalDate dueDate);

	@Override
	/**
	 * Finds an order by its ID.
	 *
	 * @param id the order ID
	 * @return optional order
	 */
	@EntityGraph(value = Order.ENTITY_GRAPTH_FULL, type = EntityGraphType.LOAD)
	Optional<Order> findById(Long id);

	/**
	 * Counts orders with due date after the specified date.
	 *
	 * @param dueDate the due date filter
	 * @return count of matching orders
	 */
	long countByDueDateAfter(LocalDate dueDate);

	/**
	 * Counts orders by customer name (case-insensitive).
	 *
	 * @param searchQuery the customer name filter
	 * @return count of matching orders
	 */
	long countByCustomerFullNameContainingIgnoreCase(String searchQuery);

	/**
	 * Counts orders by customer name and due date after the specified date.
	 *
	 * @param searchQuery the customer name filter
	 * @param dueDate     the due date filter
	 * @return count of matching orders
	 */
	long countByCustomerFullNameContainingIgnoreCaseAndDueDateAfter(String searchQuery, LocalDate dueDate);

	long countByDueDate(LocalDate dueDate);

	long countByDueDateAndStateIn(LocalDate dueDate, Collection<OrderState> state);

	long countByState(OrderState state);

	@Query("SELECT month(dueDate) as month, count(*) as deliveries FROM OrderInfo o where o.state=?1 and year(dueDate)=?2 group by month(dueDate)")
	List<Object[]> countPerMonth(OrderState orderState, int year);

	@Query("SELECT year(o.dueDate) as y, month(o.dueDate) as m, sum(oi.quantity*p.price) as deliveries FROM OrderInfo o JOIN o.items oi JOIN oi.product p where o.state=?1 and year(o.dueDate)<=?2 AND year(o.dueDate)>=(?2-3) group by year(o.dueDate), month(o.dueDate) order by y desc, month(o.dueDate)")
	List<Object[]> sumPerMonthLastThreeYears(OrderState orderState, int year);

	@Query("SELECT day(dueDate) as day, count(*) as deliveries FROM OrderInfo o where o.state=?1 and year(dueDate)=?2 and month(dueDate)=?3 group by day(dueDate)")
	List<Object[]> countPerDay(OrderState orderState, int year, int month);

	@Query("SELECT sum(oi.quantity), p FROM OrderInfo o JOIN o.items oi JOIN oi.product p WHERE o.state=?1 AND year(o.dueDate)=?2 AND month(o.dueDate)=?3 GROUP BY p.id ORDER BY p.id")
	List<Object[]> countPerProduct(OrderState orderState, int year, int month);

}
