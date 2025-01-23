import {Component, input, output} from '@angular/core';
import {ItemWithOffersDto} from "../../dto/ItemWithOffersDto";
import {ItemCardComponent} from "./item-card/item-card.component";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-item-container',
  standalone: true,
  imports: [
    ItemCardComponent,
    NgIf,
    NgForOf
  ],
  templateUrl: './item-container.component.html',
  styleUrl: './item-container.component.scss'
})
export class ItemContainerComponent {
  items = input.required<ItemWithOffersDto[] | undefined>();
  addItem = output<number>();
}
