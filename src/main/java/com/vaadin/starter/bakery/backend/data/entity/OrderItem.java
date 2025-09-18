package com.vaadin.starter.bakery.backend.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OrderItem extends AbstractEntity {

	@ManyToOne
	@NotNull(message = "{bakery.pickup.product.required}")
	private Product product;

	@Min(1)
	@NotNull
	private Integer quantity = 1;

	@Size(max = 255)
	private String comment;

	/**
	 * Returns the product associated with this order item.
	 *
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product for this order item.
	 *
	 * @param product product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Returns the quantity of the product in this order item.
	 *
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the product in this order item.
	 *
	 * @param quantity quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Returns the comment for this order item.
	 *
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment for this order item.
	 *
	 * @param comment comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Returns the total price for this order item (quantity * product price).
	 *
	 * @return total price
	 */
	public int getTotalPrice() {
		return quantity == null || product == null ? 0 : quantity * product.getPrice();
	}
}
