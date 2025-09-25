package com.vaadin.starter.bakery.testbench.elements.ui;

import java.util.Optional;

import com.vaadin.flow.component.confirmdialog.testbench.ConfirmDialogElement;
import com.vaadin.flow.component.dialog.testbench.DialogElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.HasElementQuery;
import com.vaadin.testbench.TestBenchElement;

/**
 * Interface for UI elements that provide CRUD (Create, Read, Update, Delete) operations.
 */
public interface HasCrudView extends HasElementQuery {

	/**
	 * Returns the class of the form element used in the CRUD view.
	 * @param <T> the type of TestBenchElement
	 * @return the form class
	 */
	<T extends TestBenchElement> Class<T> getFormClass();

	/**
	 * Returns the grid element of the CRUD view.
	 * @return GridElement instance
	 */
	default GridElement getGrid() {
		return $(GridElement.class).first();
	}

	/**
	 * Returns an optional confirm dialog element if present.
	 * @return Optional of ConfirmDialogElement
	 */
	default Optional<ConfirmDialogElement> getConfirmDialog() {
		ElementQuery<ConfirmDialogElement> query = $(ConfirmDialogElement.class).onPage();
		return query.exists() ? Optional.of(query.first()) : Optional.empty();
	}

	/**
	 * Returns an optional dialog element if present.
	 * @return Optional of DialogElement
	 */
	default Optional<DialogElement> getDialog() {
		ElementQuery<DialogElement> query = $(DialogElement.class).onPage();
		return query.exists() ? Optional.of(query.first()) : Optional.empty();
	}

	/**
	 * Returns the form layout element from the dialog.
	 * @return FormLayoutElement instance
	 */
	default FormLayoutElement getForm() {
		return getDialog().get().$(getFormClass()).first().$(FormLayoutElement.class).waitForFirst();
	}

}
