package com.vaadin.starter.bakery.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Product extends AbstractEntity {

	@NotBlank(message = "{bakery.name.required}")
	@Size(max = 255)
	@Column(unique = true)
	private String name;

	// Real price * 100 as an int to avoid rounding errors
	@Min(value = 0, message = "{bakery.price.limits}")
	@Max(value = 100000, message = "{bakery.price.limits}")
	private Integer price;

	/**
	 * Returns the product name.
	 * @return product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the product name.
	 * @param name product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the product price (real price * 100).
	 * @return product price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * Sets the product price (real price * 100).
	 * @param price product price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Returns the product name as a string.
	 * @return product name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Checks if this product is equal to another object.
	 * @param o the other object
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		Product that = (Product) o;
		return Objects.equals(name, that.name) &&
				Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name, price);
	}
}
