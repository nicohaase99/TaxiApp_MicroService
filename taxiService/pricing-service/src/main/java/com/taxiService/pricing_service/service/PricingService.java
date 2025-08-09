package com.taxiService.pricing_service.service;

import com.taxiService.pricing_service.dto.OrderPricingRequest;
import com.taxiService.pricing_service.dto.PricingResponse;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    private static final double BASE_FARE = 8.0;
    private static final double PER_MILE_RATE = 1.2;
    private static final double PER_PASSENGER_RATE = 1.5;

    public PricingResponse calculatePrice(OrderPricingRequest request) {
        double totalPrice = BASE_FARE +
                (request.getTravelDistance() * PER_MILE_RATE) +
                (request.getNumberOfPassengers() * PER_PASSENGER_RATE);

        return new PricingResponse(totalPrice);
    }

    private double calculatePassenger(int numberOfPassengers) {
        if (numberOfPassengers <= 2) {
            return 1.0;
        } else if (numberOfPassengers <= 4) {
            return 1.2;
        } else {
            return 1.5;
        }
    }
    private double calculateDistance(int travelDistance) {
        if (travelDistance <= 5) {
            return 2.0;
        } else if (travelDistance <= 10) {
            return 1.75;
        } else if (travelDistance <= 20) {
            return 1.5;
        } else if (travelDistance <= 50) {
            return 1.2;
        } else {
            return 1.0;
        }
    }

    public PricingResponse calculateOrderPrice(OrderPricingRequest request) {
        return calculatePrice(request);
    }
}
