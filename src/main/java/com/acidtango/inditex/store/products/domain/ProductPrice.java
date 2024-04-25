package com.acidtango.inditex.store.products.domain;

import com.acidtango.inditex.store.products.domain.primitives.ProductPricePrimitives;
import com.acidtango.inditex.store.shared.ids.PriceId;

public class ProductPrice {
    final PriceId priceList;
    final Duration temporalMoment;
    final Integer priority;
    final Double price;
    final Currency currency;

    public ProductPrice(PriceId priceList, Duration temporalMoment, Integer priority, Double price, Currency currency) {
        this.priceList = priceList;
        this.temporalMoment = temporalMoment;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public static ProductPrice from(ProductPricePrimitives primitives) {
        return new ProductPrice(
            new PriceId(primitives.id()),
            new Duration(primitives.startDate(), primitives.endDate()),
            primitives.priority(),
            primitives.price(),
            primitives.currency()
        );
    }

    public ProductPricePrimitives toPrimitives() {
        return new ProductPricePrimitives(
            priceList.getId(),
            temporalMoment.startDate(),
            temporalMoment.endDate(),
            priority,
            price,
            currency
        );
    }

    public Integer getPriority() {
        return priority;
    }
}
