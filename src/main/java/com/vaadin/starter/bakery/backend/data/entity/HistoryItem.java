package com.vaadin.starter.bakery.backend.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vaadin.starter.bakery.backend.data.OrderState;

@Entity
public class HistoryItem extends AbstractEntity {

	private OrderState newState;

	@NotBlank
	@Size(max = 255)
	private String message;

	@NotNull
	private LocalDateTime timestamp;
	@ManyToOne
	@NotNull
	private User createdBy;

	/**
	 * Default constructor required by JPA and Spring Data.
	 */
	HistoryItem() {
		// Empty constructor is needed by Spring Data / JPA
	}

	/**
	 * Constructs a HistoryItem with the given user and message, setting the timestamp to now.
	 *
	 * @param createdBy the user who created the history item
	 * @param message   the message for the history item
	 */
	public HistoryItem(User createdBy, String message) {
		this.createdBy = createdBy;
		this.message = message;
		timestamp = LocalDateTime.now();
	}

	/**
	 * Returns the new state for this history item.
	 *
	 * @return new order state
	 */
	public OrderState getNewState() {
		return newState;
	}

	/**
	 * Sets the new state for this history item.
	 *
	 * @param newState new order state
	 */
	public void setNewState(OrderState newState) {
		this.newState = newState;
	}

	/**
	 * Returns the message for this history item.
	 *
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message for this history item.
	 *
	 * @param message message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the timestamp for this history item.
	 *
	 * @return timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp for this history item.
	 *
	 * @param timestamp timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Returns the user who created this history item.
	 *
	 * @return user who created the item
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the user who created this history item.
	 *
	 * @param createdBy user to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}
