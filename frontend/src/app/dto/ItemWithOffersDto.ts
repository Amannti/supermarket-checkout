import {OfferDto} from "./OfferDto";

export type ItemWithOffersDto = {
  id: number;
  name: string;
  price: number;
  offers: OfferDto[]
}
