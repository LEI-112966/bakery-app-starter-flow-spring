package com.vaadin.starter.bakery.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Represents a user entity in the system. Stores user credentials, personal information, and role.
 * <p>
 * The email is stored in lowercase and must be unique. The password is stored as a hash.
 * The entity also tracks whether the user is locked.
 * </p>
 */
@Entity(name="UserInfo")
public class User extends AbstractEntity {

	/**
	 * The unique email address of the user. Must be a valid email and is stored in lowercase.
	 */
	@NotEmpty
	@Email
	@Size(max = 255)
	@Column(unique = true)
	private String email;

	/**
	 * The hashed password of the user. Must be at least 4 characters long.
	 */
	@NotNull
	@Size(min = 4, max = 255)
	private String passwordHash;

	/**
	 * The first name of the user.
	 */
	@NotBlank
	@Size(max = 255)
	private String firstName;

	/**
	 * The last name of the user.
	 */
	@NotBlank
	@Size(max = 255)
	private String lastName;

	/**
	 * The role assigned to the user (e.g., admin, user).
	 */
	@NotBlank
	@Size(max = 255)
	private String role;

	/**
	 * Indicates whether the user account is locked.
	 */
	private boolean locked = false;

	/**
	 * Prepares user data before persisting or updating by converting email to lowercase.
	 */
	@PrePersist
	@PreUpdate
	private void prepareData(){
		this.email = email == null ? null : email.toLowerCase();
	}

	/**
	 * Constructs an empty User instance.
	 */
	public User() {
		// An empty constructor is needed for all beans
	}

	/**
	 * Returns the hashed password of the user.
	 * @return the password hash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Sets the hashed password of the user.
	 * @param passwordHash the password hash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Returns the first name of the user.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of the user.
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the role of the user.
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Returns the email address of the user.
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns whether the user account is locked.
	 * @return true if locked, false otherwise
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Sets the locked status of the user account.
	 * @param locked true to lock the account, false to unlock
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Checks if this user is equal to another object.
	 * @param o the object to compare
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
		User that = (User) o;
		return locked == that.locked &&
				Objects.equals(email, that.email) &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName) &&
				Objects.equals(role, that.role);
	}

	/**
	 * Returns the hash code for this user.
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), email, firstName, lastName, role, locked);
	}
}
