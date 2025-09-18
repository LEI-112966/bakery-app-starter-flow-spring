package com.vaadin.starter.bakery.ui.views.storefront.beans;

/**
 * Representa dados de contagem de pedidos com informações de gráfico.
 * <p>
 * Estende OrdersCountData para incluir o total geral de pedidos.
 * </p>
 *
 * @author GitHub Copilot
 */
public class OrdersCountDataWithChart extends OrdersCountData {

	/**
	 * Total geral de pedidos.
	 */
	private Integer overall;

	/**
	 * Construtor padrão.
	 */
	public OrdersCountDataWithChart() {

	}

	/**
	 * Construtor com parâmetros.
	 *
	 * @param title título
	 * @param subtitle subtítulo
	 * @param count quantidade
	 * @param overall total geral
	 */
	public OrdersCountDataWithChart(String title, String subtitle, Integer count, Integer overall) {
		super(title, subtitle, count);
		this.overall = overall;
	}

	/**
	 * Retorna o total geral de pedidos.
	 *
	 * @return total geral
	 */
	public Integer getOverall() {
		return overall;
	}

	/**
	 * Define o total geral de pedidos.
	 *
	 * @param overall total geral
	 */
	public void setOverall(Integer overall) {
		this.overall = overall;
	}

}