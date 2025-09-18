package com.vaadin.starter.bakery.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class PickupLocation extends AbstractEntity {

	@Size(max = 255)
	@NotBlank
	@Column(unique = true)
	private String name;

	/**
	 * Returns the pickup location name.
	 *
	 * @return location name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the pickup location name.
	 *
	 * @param name location name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
