package com.vaadin.starter.bakery.backend.data;

/**
 * Represents delivery statistics for the bakery dashboard.
 * Contains metrics for deliveries and orders for today and tomorrow.
 */
public class DeliveryStats {

    /**
     * Number of orders delivered today.
     */
    private int deliveredToday;
    /**
     * Number of orders due today.
     */
    private int dueToday;
    /**
     * Number of orders due tomorrow.
     */
    private int dueTomorrow;
    /**
     * Number of orders not available for delivery today.
     */
    private int notAvailableToday;
    /**
     * Number of new orders received.
     */
    private int newOrders;

    /**
     * Gets the number of orders delivered today.
     * @return delivered today count
     */
    public int getDeliveredToday() {
        return deliveredToday;
    }

    /**
     * Sets the number of orders delivered today.
     * @param deliveredToday delivered today count
     */
    public void setDeliveredToday(int deliveredToday) {
        this.deliveredToday = deliveredToday;
    }

    /**
     * Gets the number of orders due today.
     * @return due today count
     */
    public int getDueToday() {
        return dueToday;
    }

    /**
     * Sets the number of orders due today.
     * @param dueToday due today count
     */
    public void setDueToday(int dueToday) {
        this.dueToday = dueToday;
    }

    /**
     * Gets the number of orders due tomorrow.
     * @return due tomorrow count
     */
    public int getDueTomorrow() {
        return dueTomorrow;
    }

    /**
     * Sets the number of orders due tomorrow.
     * @param dueTomorrow due tomorrow count
     */
    public void setDueTomorrow(int dueTomorrow) {
        this.dueTomorrow = dueTomorrow;
    }

    /**
     * Gets the number of orders not available for delivery today.
     * @return not available today count
     */
    public int getNotAvailableToday() {
        return notAvailableToday;
    }

    /**
     * Sets the number of orders not available for delivery today.
     * @param notAvailableToday not available today count
     */
    public void setNotAvailableToday(int notAvailableToday) {
        this.notAvailableToday = notAvailableToday;
    }

    /**
     * Gets the number of new orders received.
     * @return new orders count
     */
    public int getNewOrders() {
        return newOrders;
    }

    /**
     * Sets the number of new orders received.
     * @param newOrders new orders count
     */
    public void setNewOrders(int newOrders) {
        this.newOrders = newOrders;
    }

}
