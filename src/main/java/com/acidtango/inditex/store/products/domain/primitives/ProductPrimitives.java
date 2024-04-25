package com.acidtango.inditex.store.products.domain.primitives;

public record ProductPrimitives(
        Integer id,
        Integer brandId,
        ProductPricePrimitives price) {
}
