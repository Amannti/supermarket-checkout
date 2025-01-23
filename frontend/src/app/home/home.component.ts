import {Component, inject, Signal} from '@angular/core';
import {ItemContainerComponent} from "./item-container/item-container.component";
import {ItemService} from "../service/item.service";
import {BackendService} from "../service/backend.service";
import {HttpClientModule} from "@angular/common/http";
import {CartService} from "../service/cart.service";
import {CartDto} from "../dto/CartDto";
import {CartComponent} from "./cart/cart.component";
import {AsyncPipe} from "@angular/common";
import {Observable} from "rxjs";
import {ItemWithOffersDto} from "../dto/ItemWithOffersDto";
import {toSignal} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    ItemContainerComponent,
    HttpClientModule,
    CartComponent,
    AsyncPipe
  ],
  providers: [CartService, ItemService, BackendService, HttpClientModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  private readonly itemService = inject(ItemService);
  private readonly cartService = inject(CartService);

  cart$: Observable<CartDto> = this.cartService.getCart();

  itemsWithOffers: Signal<ItemWithOffersDto[] | undefined> = toSignal(this.itemService.getItems());

  addItem(itemId: number) {
    this.cart$ = this.cartService.addItem(itemId);
  }

  removeItem(itemId: number) {
    this.cart$ = this.cartService.removeItem(itemId);
  }

  payCart() {
    this.cartService.payCart().subscribe(() => {
      alert("Your cart is paid");
      this.cart$ = this.cartService.getCart();
    })
  }
}
