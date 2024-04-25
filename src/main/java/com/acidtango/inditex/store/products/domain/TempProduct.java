package com.acidtango.inditex.store.products.domain;

import com.acidtango.inditex.store.products.domain.primitives.ProductPrimitives;
import com.acidtango.inditex.store.shared.ids.BrandId;
import com.acidtango.inditex.store.shared.ids.ProductId;

public class TempProduct {
    final ProductId id;
    final BrandId brandId;
    final ProductPrice price;

    public static TempProduct from (ProductPrimitives primitives) {
        return new TempProduct(
            new ProductId(primitives.id()),
            new BrandId(primitives.brandId()),
            ProductPrice.from(primitives.price()));
    }

    public TempProduct(ProductId id, BrandId brandId, ProductPrice price) {
        this.id = id;
        this.brandId = brandId;
        this.price = price;
    }

    public Integer getPriority() {
        return price.getPriority();
    }

    public ProductPrimitives toPrimitives() {
        return new ProductPrimitives(id.getId(), brandId.getId(), price.toPrimitives());
    }
}
