package com.vaadin.starter.bakery.backend.data.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Customer extends AbstractEntity {

	@NotBlank
	@Size(max = 255)
	private String fullName;

	@NotBlank
	@Size(max = 20, message = "{bakery.phone.number.invalid}")
	// A simple phone number checker, allowing an optional international prefix
	// plus a variable number of digits that could be separated by dashes or
	// spaces
	@Pattern(regexp = "^(\\+\\d+)?([ -]?\\d+){4,14}$", message = "{bakery.phone.number.invalid}")
	private String phoneNumber;
	
	@Size(max = 255)
	private String details;

	/**
	 * Returns the full name of the customer.
	 * @return full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name of the customer.
	 * @param fullName full name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Returns the phone number of the customer.
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the customer.
	 * @param phoneNumber phone number to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns additional details about the customer.
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets additional details about the customer.
	 * @param details details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
