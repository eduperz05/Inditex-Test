package com.acidtango.inditex.store.products.infrastructure.repositories.entities;

import com.acidtango.inditex.store.products.domain.Currency;
import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.domain.primitives.ProductPricePrimitives;
import com.acidtango.inditex.store.products.domain.primitives.ProductPrimitives;

public class ProductEntityMapper {

    public static TempProduct mapToDomain(ProductEntity productEntity) {
        return TempProduct.from(
                toPrimitives(productEntity)
        );
    }

    private static ProductPrimitives toPrimitives(ProductEntity productEntity) {
        return new ProductPrimitives(
                productEntity.productId,
                productEntity.brandId,
                new ProductPricePrimitives(
                        productEntity.priceList,
                        productEntity.startDate,
                        productEntity.endDate,
                        productEntity.priority,
                        productEntity.price,
                        Currency.valueOf(productEntity.currency)
                )
        );
    }

    public static ProductEntity mapToEntity(TempProduct tempProduct) {
        return new ProductEntity(
                null,
                tempProduct.toPrimitives().brandId(),
                tempProduct.toPrimitives().price().startDate(),
                tempProduct.toPrimitives().price().endDate(),
                tempProduct.toPrimitives().price().id(),
                tempProduct.toPrimitives().id(),
                tempProduct.toPrimitives().price().priority(),
                tempProduct.toPrimitives().price().price(),
                tempProduct.toPrimitives().price().currency().name());
    }
}
