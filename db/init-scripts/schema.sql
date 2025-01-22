CREATE TABLE Item
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100)     NOT NULL,
    price DOUBLE PRECISION NOT NULL
);

CREATE TABLE Offer
(
    id           SERIAL PRIMARY KEY,
    item_id      INTEGER          NOT NULL,
    pieces       INTEGER          NOT NULL,
    bundle_price DOUBLE PRECISION NOT NULL,
    is_active    BOOLEAN          NOT NULL DEFAULT true,
    CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES Item (id) ON DELETE CASCADE
);

CREATE TABLE Cart
(
    id       SERIAL PRIMARY KEY,
    items    JSONB            NOT NULL DEFAULT '[]',
    total    DOUBLE PRECISION NOT NULL,
    is_payed BOOLEAN          NOT NULL DEFAULT false
);
