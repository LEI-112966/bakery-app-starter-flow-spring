package com.vaadin.starter.bakery.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vaadin.starter.bakery.backend.data.entity.Product;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.ProductRepository;

@Service
public class ProductService implements FilterableCrudService<Product> {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Finds products matching the given filter or returns all products if no filter is provided.
	 * @param filter optional filter string
	 * @param pageable pagination information
	 * @return page of matching products
	 */
	@Override
	public Page<Product> findAnyMatching(Optional<String> filter, Pageable pageable) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return productRepository.findByNameLikeIgnoreCase(repositoryFilter, pageable);
		} else {
			return find(pageable);
		}
	}

	/**
	 * Counts products matching the given filter or returns total count if no filter is provided.
	 * @param filter optional filter string
	 * @return count of matching products
	 */
	@Override
	public long countAnyMatching(Optional<String> filter) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return productRepository.countByNameLikeIgnoreCase(repositoryFilter);
		} else {
			return count();
		}
	}

	/**
	 * Finds all products for the given pageable.
	 * @param pageable pagination information
	 * @return page of products
	 */
	public Page<Product> find(Pageable pageable) {
		return productRepository.findBy(pageable);
	}

	@Override
	public JpaRepository<Product, Long> getRepository() {
		return productRepository;
	}

	@Override
	public Product createNew(User currentUser) {
		return new Product();
	}

	@Override
	public Product save(User currentUser, Product entity) {
		try {
			return FilterableCrudService.super.save(currentUser, entity);
		} catch (DataIntegrityViolationException e) {
			throw new UserFriendlyDataException(
					"There is already a product with that name. Please select a unique name for the product.");
		}

	}

}
