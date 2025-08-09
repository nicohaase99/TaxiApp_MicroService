package com.taxiService.order_service.dto;

public class OrderResponse {

    private long orderId;
    private String customerName;
    private int numberOfPassengers;
    private int travelDistance;
    private double totalPrice;
    private String status;

    public OrderResponse() {
    }

    public OrderResponse(long orderId, String customerName, int numberOfPassengers, int travelDistance, double totalPrice, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.numberOfPassengers = numberOfPassengers;
        this.travelDistance = travelDistance;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
