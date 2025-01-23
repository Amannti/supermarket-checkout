import {Component, input, output} from '@angular/core';
import {ItemWithOffersDto} from "../../../dto/ItemWithOffersDto";
import {DecimalPipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-item-card',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    DecimalPipe
  ],
  templateUrl: './item-card.component.html',
  styleUrl: './item-card.component.scss'
})
export class ItemCardComponent {
  item = input.required<ItemWithOffersDto>();
  addItem = output<number>();
}
