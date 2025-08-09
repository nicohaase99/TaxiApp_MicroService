import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { OrderService, OrderRequest, OrderResponse } from './order.service';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Taxi Service Order Form';

  orderRequest:  OrderRequest = {
    customerName: " ",
    numberOfPassengers: 1,
    travelDistance: 1
  };

  orderResponse: OrderResponse | null = null;
  errorMessage: string | null = null;
  isLoading: boolean = false;

  constructor(private orderService: OrderService) {}

  async onSubmit() {
    if (this.isFormValid()){
      this.isLoading = true;
      this.errorMessage = null;
      this.orderResponse = null;
      try {
        this.orderResponse = await this.orderService.createOrder(this.orderRequest);
        console.log("RESPONSE", this.orderResponse);
        this.isLoading = false;
      } catch (error) {
        this.isLoading = false;
        const err = error as { error?: { message?: string; fieldErrors?: any } };
        if (err.error && err.error.message) {
          this.errorMessage = err.error.message;
        } else if (err.error && err.error.fieldErrors) {
          this.errorMessage = "please check that all fields are filled in correctly"
        } else {
          this.errorMessage = "Failed to create an order. Please try again later.";
        }
        }
      } else {
        this.errorMessage = "Please fill in all fields correctly.";
        this.orderResponse = null;
      }
    } 

  isFormValid(): boolean {
    return this.orderRequest.customerName.trim() !== '' &&
    this.orderRequest.numberOfPassengers > 0 &&
    this.orderRequest.travelDistance > 0;
  }

  clearForm() {
    this.orderRequest = {
      customerName: " ",
      numberOfPassengers: 1,
      travelDistance: 1
    };
    this.orderResponse = null;
    this.errorMessage = null;
    this.isLoading = false;
  }
}
