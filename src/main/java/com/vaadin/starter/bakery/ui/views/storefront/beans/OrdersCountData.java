package com.vaadin.starter.bakery.ui.views.storefront.beans;

/**
 * Representa dados de contagem de pedidos para exibição em gráficos ou relatórios.
 *
 * @author GitHub Copilot
 */
public class OrdersCountData {

	/**
	 * Título do gráfico ou relatório.
	 */
	private String title;
	/**
	 * Subtítulo do gráfico ou relatório.
	 */
	private String subtitle;
	/**
	 * Quantidade de pedidos.
	 */
	private Integer count;

	/**
	 * Retorna o título.
	 * @return título
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Define o título.
	 * @param title título
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retorna o subtítulo.
	 * @return subtítulo
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Define o subtítulo.
	 * @param subtitle subtítulo
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Retorna a quantidade de pedidos.
	 * @return quantidade
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Define a quantidade de pedidos.
	 * @param count quantidade
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * Construtor padrão.
	 */
	public OrdersCountData() {

	}

	/**
	 * Construtor com parâmetros.
	 * @param title título
	 * @param subtitle subtítulo
	 * @param count quantidade
	 */
	public OrdersCountData(String title, String subtitle, Integer count) {
		this.title = title;
		this.subtitle = subtitle;
		this.count = count;
	}

}