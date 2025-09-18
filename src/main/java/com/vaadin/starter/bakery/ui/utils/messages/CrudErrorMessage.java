package com.vaadin.starter.bakery.ui.utils.messages;

/**
 * Mensagens de erro padrão para operações CRUD na aplicação Bakery.
 * <p>
 * Fornece constantes para mensagens de erro comuns em operações de entidade.
 * </p>
 *
 * @author GitHub Copilot
 */
public final class CrudErrorMessage {
	/**
	 * Mensagem para entidade não encontrada.
	 */
	public static final String ENTITY_NOT_FOUND = "The selected entity was not found.";
	/**
	 * Mensagem para atualização concorrente.
	 */
	public static final String CONCURRENT_UPDATE = "Somebody else might have updated the data. Please refresh and try again.";
	/**
	 * Mensagem para operação impedida por referências.
	 */
	public static final String OPERATION_PREVENTED_BY_REFERENCES = "The operation can not be executed as there are references to entity in the database.";
	/**
	 * Mensagem para campos obrigatórios não preenchidos.
	 */
	public static final String REQUIRED_FIELDS_MISSING = "Please fill out all required fields before proceeding.";

	/**
	 * Construtor privado para evitar instanciação.
	 */
	private CrudErrorMessage() {
	}
}
