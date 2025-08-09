TaxiApp is a straightforward full-stack application for booking taxi rides. Users enter their name, travel distance (in miles), and number of passengers into a simple HTML form. The application then generates order details, including the total price for the trip.

The front end is built with Angular, providing a responsive interface that communicates with a Spring Boot microservice back end. The microservice architecture includes:

API Gateway – Routes and manages requests between services.

Eureka Service Registry – Handles service discovery for dynamic scaling.

Order Service – Manages order creation and retrieval.

Pricing Service – Calculates trip costs based on distance and passenger count.

This modular design allows each service to be developed, deployed, and scaled independently while maintaining smooth interaction between the front end and back end.

