package com.vaadin.starter.bakery.testbench.elements.ui;

import com.vaadin.flow.component.confirmdialog.testbench.ConfirmDialogElement;
import com.vaadin.flow.component.crud.testbench.CrudElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.starter.bakery.testbench.elements.components.SearchBarElement;
import com.vaadin.testbench.TestBenchElement;

/**
 * TestBench element representing a CRUD view in the UI, providing access to search bar, CRUD editor, and dialogs.
 */
public class BakeryCrudViewElement extends TestBenchElement implements HasApp {

	/**
	 * Returns the search bar element.
	 * @return SearchBarElement instance
	 */
	public SearchBarElement getSearchBar() {
		return $(SearchBarElement.class).first();
	}

	/**
	 * Returns the CRUD element.
	 * @return CrudElement instance
	 */
	public CrudElement getCrud() {
		return $(CrudElement.class).first();
	}

	/**
	 * Returns the form layout element from the CRUD editor.
	 * @return FormLayoutElement instance
	 */
	public FormLayoutElement getForm() {
		return getCrud().getEditor().$(FormLayoutElement.class).first();
	}

	/**
	 * Returns the confirm dialog for discarding changes.
	 * @return ConfirmDialogElement instance
	 */
	public ConfirmDialogElement getDiscardConfirmDialog() {
		return getCrud().$(ConfirmDialogElement.class).first();
	}

	/**
	 * Returns the confirm dialog for deleting an entity.
	 * @return ConfirmDialogElement instance
	 */
	public ConfirmDialogElement getDeleteConfirmDialog() {
		return getCrud().$(ConfirmDialogElement.class).last();
	}

	/**
	 * Opens a row for editing in the CRUD grid.
	 * @param row the row index
	 * @param editCol the column index for editing
	 */
	public void openRowForEditing(int row, int editCol) {
		getCrud().getGrid().getCell(row, editCol).$(TestBenchElement.class).first().click();
	}
}
