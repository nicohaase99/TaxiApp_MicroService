package com.taxiService.api_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FallBackController {

    @RequestMapping("fallback/orders")
    public ResponseEntity <Map<String, Object>> orderServiceFallBack() {
        return createFallBackResponse(
                "Order Service is not available at this time.",
                "We apologize for the inconvenience. Please try again later.",
                "ORDER_SERVICE_IS_DOWN"
                );
    }
    @RequestMapping("fallback/pricing")
    public ResponseEntity <Map<String, Object>> pricingServiceFallBack() {
        return createFallBackResponse(
                "Pricing Service is not available at this time.",
                "We apologize for the inconvenience. Please try again later.",
                "PRICING_SERVICE_IS_DOWN"
                );
    }
    private ResponseEntity <Map<String,Object>> createFallBackResponse(String title, String message, String errorCode) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", true);
        response.put("title", title);
        response.put("message", message);
        response.put("errorCode", errorCode);
        response.put("timestamp", LocalDateTime.now());
        response.put("suggestion", "This issue will be resolved shortly. Please try again later.");

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
