package com.acidtango.inditex.store.products.domain.primitives;

import com.acidtango.inditex.store.products.domain.Currency;

import java.time.Instant;

public record ProductPricePrimitives (
    Integer id,
    Instant startDate,
    Instant endDate,
    Integer priority,
    Double price,
    Currency currency) {
}
