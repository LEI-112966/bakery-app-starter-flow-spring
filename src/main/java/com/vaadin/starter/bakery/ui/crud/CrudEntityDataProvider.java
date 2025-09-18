package com.vaadin.starter.bakery.ui.crud;

import java.util.List;

import com.vaadin.starter.bakery.backend.data.entity.AbstractEntity;
import com.vaadin.starter.bakery.backend.service.FilterableCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;

import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.QuerySortOrderBuilder;

public class CrudEntityDataProvider<T extends AbstractEntity> extends FilterablePageableDataProvider<T, String> {

	private final FilterableCrudService<T> crudService;
	private List<QuerySortOrder> defaultSortOrders;

	public CrudEntityDataProvider(FilterableCrudService<T> crudService) {
		this.crudService = crudService;
		setSortOrders();
	}

	/**
	 * Sets the default sort orders for the data provider.
	 */
	private void setSortOrders() {
		QuerySortOrderBuilder builder = new QuerySortOrderBuilder();
		builder.thenAsc("id");
		defaultSortOrders = builder.build();
	}

	/**
	 * Fetches a page of entities from the backend using the given query and pageable.
	 * @param query the query object
	 * @param pageable the pageable object
	 * @return a page of entities
	 */
	@Override
	protected Page<T> fetchFromBackEnd(Query<T, String> query, Pageable pageable) {
		return crudService.findAnyMatching(query.getFilter(), pageable);
	}

	/**
	 * Returns the default sort orders for the data provider.
	 * @return list of default sort orders
	 */
	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		return defaultSortOrders;
	}

	/**
	 * Returns the total number of entities matching the query filter.
	 * @param query the query object
	 * @return total number of matching entities
	 */
	@Override
	protected int sizeInBackEnd(Query<T, String> query) {
		return (int) crudService.countAnyMatching(query.getFilter());
	}

}
