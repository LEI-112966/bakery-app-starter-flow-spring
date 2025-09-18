package com.vaadin.starter.bakery.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.starter.bakery.backend.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Finds all products for the given pageable.
	 * @param page pagination information
	 * @return page of products
	 */
	Page<Product> findBy(Pageable page);

	/**
	 * Finds products by name filter (case-insensitive).
	 * @param name the name filter string
	 * @param page pagination information
	 * @return page of matching products
	 */
	Page<Product> findByNameLikeIgnoreCase(String name, Pageable page);

	/**
	 * Counts products by name filter (case-insensitive).
	 * @param name the name filter string
	 * @return count of matching products
	 */
	int countByNameLikeIgnoreCase(String name);

}
