import {inject, Signal} from "@angular/core";
import {BackendService} from "./backend.service";
import {ItemWithOffersDto} from "../dto/ItemWithOffersDto";

export class ItemService {
  private backendService = inject(BackendService);

  getItems(): Signal<ItemWithOffersDto[] | undefined> {
    return this.backendService.get<ItemWithOffersDto[]>('items');
  }
}
