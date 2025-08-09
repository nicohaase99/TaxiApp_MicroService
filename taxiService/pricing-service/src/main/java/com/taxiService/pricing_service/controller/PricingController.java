package com.taxiService.pricing_service.controller;

import jakarta.validation.Valid;

import com.taxiService.pricing_service.dto.OrderPricingRequest;
import com.taxiService.pricing_service.dto.PricingResponse;
import com.taxiService.pricing_service.service.PricingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@Validated
public class PricingController {

    private final PricingService pricingService;

    @Autowired
    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<PricingResponse> calculateOrderPrice(@Valid @RequestBody OrderPricingRequest request) {
        try {
            PricingResponse response = pricingService.calculateOrderPrice(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("Error calculating price: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Pricing Service is running!");
    }
}

