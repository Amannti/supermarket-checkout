export type ItemWithOffersDto = {
  id: number;
  name: string;
  price: number;
  offers: OfferDto[]
}

export type OfferDto = {
  pieces: number;
  bundlePrice: number;
}
