package com.vaadin.starter.bakery.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.starter.bakery.backend.data.entity.PickupLocation;

public interface PickupLocationRepository extends JpaRepository<PickupLocation, Long> {

	/**
	 * Finds pickup locations by name filter (case-insensitive).
	 * @param nameFilter the name filter string
	 * @param pageable pagination information
	 * @return page of matching pickup locations
	 */
	Page<PickupLocation> findByNameLikeIgnoreCase(String nameFilter, Pageable pageable);

	/**
	 * Counts pickup locations by name filter (case-insensitive).
	 * @param nameFilter the name filter string
	 * @return count of matching pickup locations
	 */
	int countByNameLikeIgnoreCase(String nameFilter);
}
