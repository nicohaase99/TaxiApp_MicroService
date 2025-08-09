package com.taxiService.pricing_service.dto;

public class OrderPricingRequest {
    private int travelDistance;
    private int numberOfPassengers;

    public OrderPricingRequest() {
    }

    public OrderPricingRequest(int travelDistance, int numberOfPassengers) {
        this.travelDistance = travelDistance;
        this.numberOfPassengers = numberOfPassengers;
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
