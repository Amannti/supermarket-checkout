import {inject, Signal} from "@angular/core";
import {BackendService} from "./backend.service";
import {CartDto} from "../dto/CartDto";

export class CartService {
  private backendService = inject(BackendService);

  getCart() {
    return this.backendService.get<CartDto>('carts');
  }

  addItem(itemId: number) {
    return this.backendService.post<CartDto>(`carts/item/${itemId}`);
  }

  removeItem(itemId: number) {
    return this.backendService.delete<CartDto>(`carts/item/${itemId}`);
  }
}
