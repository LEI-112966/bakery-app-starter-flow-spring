package com.vaadin.starter.bakery.backend.data.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	/**
	 * Returns the unique identifier of the entity.
	 * @return entity ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the version of the entity for optimistic locking.
	 * @return entity version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Returns the hash code for this entity.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, version);
	}

	/**
	 * Checks if this entity is equal to another object.
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
		AbstractEntity that = (AbstractEntity) o;
		return version == that.version &&
				Objects.equals(id, that.id);
	}
}
