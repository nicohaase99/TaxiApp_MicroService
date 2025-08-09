import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

export interface OrderRequest {
  customerName: string;
  numberOfPassengers: number;
  travelDistance: number;
  
}
export interface OrderResponse {
  orderId: string;
  customerName: string;
  numberOfPassengers: number;
  travelDistance: number;
  totalPrice: number;
  status: string;
  

}

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl = 'http://localhost:8081/api/orders';

  constructor(private http: HttpClient) { }

  async createOrder(orderRequest: OrderRequest): Promise<OrderResponse> {
    return firstValueFrom(this.http.post<OrderResponse>(this.apiUrl, orderRequest));
  }
}
