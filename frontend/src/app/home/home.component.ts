import {Component, inject} from '@angular/core';
import {ItemContainerComponent} from "./item-container/item-container.component";
import {ItemService} from "../service/item.service";
import {BackendService} from "../service/backend.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    ItemContainerComponent,
    HttpClientModule
  ],
  providers: [ItemService, BackendService, HttpClientModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  private itemService = inject(ItemService);

  itemsWithOffers = this.itemService.getItems();

}
