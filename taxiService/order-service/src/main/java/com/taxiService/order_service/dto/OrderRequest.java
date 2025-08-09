package com.taxiService.order_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class OrderRequest {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Travel distance is required")
    private int travelDistance;

    @Positive(message = "Number of passengers must be at least 1")
    private int numberOfPassengers;

    @Positive (message = "Travel distance must be at least 1")

    public OrderRequest() {
    }

    public OrderRequest(String customerName, int travelDistance, int numberOfPassengers) {
        this.customerName = customerName;
        this.travelDistance = travelDistance;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
