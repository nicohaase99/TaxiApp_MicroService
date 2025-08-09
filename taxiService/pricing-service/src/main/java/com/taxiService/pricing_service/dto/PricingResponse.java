package com.taxiService.pricing_service.dto;

public class PricingResponse {

    private double totalPrice;

    public PricingResponse() {
    }

    public PricingResponse(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "PricingResponse{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
