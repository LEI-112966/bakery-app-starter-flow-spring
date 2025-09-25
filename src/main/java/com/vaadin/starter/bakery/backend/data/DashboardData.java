package com.vaadin.starter.bakery.backend.data;

import java.util.LinkedHashMap;
import java.util.List;

import com.vaadin.starter.bakery.backend.data.entity.Product;

/**
 * Data container for dashboard statistics and metrics.
 */
public class DashboardData {

    /**
     * Delivery statistics summary.
     */
    private DeliveryStats deliveryStats;
    /**
     * List of deliveries for each day of the current month.
     */
    private List<Number> deliveriesThisMonth;
    /**
     * List of deliveries for each month of the current year.
     */
    private List<Number> deliveriesThisYear;
    /**
     * Sales data per month. Each row represents a month, columns represent sales metrics.
     */
    private Number[][] salesPerMonth;
    /**
     * Map of products to the number of deliveries for each product.
     */
    private LinkedHashMap<Product, Integer> productDeliveries;

    /**
     * Gets the delivery statistics summary.
     * @return the delivery statistics
     */
    public DeliveryStats getDeliveryStats() {
        return deliveryStats;
    }

    /**
     * Sets the delivery statistics summary.
     * @param deliveryStats the delivery statistics
     */
    public void setDeliveryStats(DeliveryStats deliveryStats) {
        this.deliveryStats = deliveryStats;
    }

    /**
     * Gets the list of deliveries for each day of the current month.
     * @return deliveries per day for the current month
     */
    public List<Number> getDeliveriesThisMonth() {
        return deliveriesThisMonth;
    }

    /**
     * Sets the list of deliveries for each day of the current month.
     * @param deliveriesThisMonth deliveries per day for the current month
     */
    public void setDeliveriesThisMonth(List<Number> deliveriesThisMonth) {
        this.deliveriesThisMonth = deliveriesThisMonth;
    }

    /**
     * Gets the list of deliveries for each month of the current year.
     * @return deliveries per month for the current year
     */
    public List<Number> getDeliveriesThisYear() {
        return deliveriesThisYear;
    }

    /**
     * Sets the list of deliveries for each month of the current year.
     * @param deliveriesThisYear deliveries per month for the current year
     */
    public void setDeliveriesThisYear(List<Number> deliveriesThisYear) {
        this.deliveriesThisYear = deliveriesThisYear;
    }

    /**
     * Sets the sales data per month.
     * @param salesPerMonth sales data per month
     */
    public void setSalesPerMonth(Number[][] salesPerMonth) {
        this.salesPerMonth = salesPerMonth;
    }

    /**
     * Gets the sales data for a specific month.
     * @param i the month index
     * @return sales data for the specified month
     */
    public Number[] getSalesPerMonth(int i) {
        return salesPerMonth[i];
    }

    /**
     * Gets the map of products to the number of deliveries for each product.
     * @return product deliveries map
     */
    public LinkedHashMap<Product, Integer> getProductDeliveries() {
        return productDeliveries;
    }

    /**
     * Sets the map of products to the number of deliveries for each product.
     * @param productDeliveries product deliveries map
     */
    public void setProductDeliveries(LinkedHashMap<Product, Integer> productDeliveries) {
        this.productDeliveries = productDeliveries;
    }

}
