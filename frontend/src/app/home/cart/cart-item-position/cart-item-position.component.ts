import {Component, input} from '@angular/core';
import {CartItemDto} from "../../../dto/CartDto";
import {DecimalPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-cart-item-position',
  standalone: true,
  imports: [
    NgIf,
    DecimalPipe
  ],
  templateUrl: './cart-item-position.component.html',
  styleUrl: './cart-item-position.component.scss'
})
export class CartItemPositionComponent {
  item = input.required<CartItemDto>();
}
