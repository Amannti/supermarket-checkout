import {Component, input, output} from '@angular/core';
import {ItemWithOffersDto} from "../../../dto/ItemWithOffersDto";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-item-card',
  standalone: true,
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './item-card.component.html',
  styleUrl: './item-card.component.scss'
})
export class ItemCardComponent {
  item = input.required<ItemWithOffersDto>();
  addItem = output<number>();
}
