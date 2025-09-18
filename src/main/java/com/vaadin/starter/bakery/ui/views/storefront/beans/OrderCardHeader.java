package com.vaadin.starter.bakery.ui.views.storefront.beans;

/**
 * Representa o cabeçalho de um card de pedido na Storefront.
 * <p>
 * Utilizado para agrupar visualmente pedidos em listas.
 * </p>
 *
 * @author GitHub Copilot
 */
public class OrderCardHeader {

	/**
	 * Texto principal do cabeçalho.
	 */
	private String main;
	/**
	 * Texto secundário do cabeçalho.
	 */
	private String secondary;

	/**
	 * Construtor do cabeçalho do card de pedido.
	 * @param main texto principal
	 * @param secondary texto secundário
	 */
	public OrderCardHeader(String main, String secondary) {
		this.main = main;
		this.secondary = secondary;
	}

	/**
	 * Retorna o texto principal.
	 * @return texto principal
	 */
	public String getMain() {
		return main;
	}

	/**
	 * Define o texto principal.
	 * @param main texto principal
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/**
	 * Retorna o texto secundário.
	 * @return texto secundário
	 */
	public String getSecondary() {
		return secondary;
	}

	/**
	 * Define o texto secundário.
	 * @param secondary texto secundário
	 */
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
}
