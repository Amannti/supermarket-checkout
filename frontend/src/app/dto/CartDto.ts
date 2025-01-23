export type CartDto = {
    items: CartItemDto[];
    total: number;
}

export type CartItemDto = {
    itemId: number;
    itemName: string;
    price: number;
    pieces: number;
    totalWithoutOffers: number;
    total: number;
}
