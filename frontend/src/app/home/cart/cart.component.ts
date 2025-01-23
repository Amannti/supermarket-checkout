import {Component, input, output} from '@angular/core';
import {CartDto} from "../../dto/CartDto";
import {DecimalPipe, NgForOf, NgIf} from "@angular/common";
import {CartItemPositionComponent} from "./cart-item-position/cart-item-position.component";

@Component({
    selector: 'app-cart',
    standalone: true,
    imports: [
        NgIf,
        CartItemPositionComponent,
        NgForOf,
        DecimalPipe
    ],
    templateUrl: './cart.component.html',
    styleUrl: './cart.component.scss'
})
export class CartComponent {
    cart = input.required<CartDto | null>();
    removeItem = output<number>();
    payCart = output<void>();
}
