package com.acidtango.inditex.store.products.domain.exceptions;

import com.acidtango.inditex.store.shared.exceptions.DomainException;
import com.acidtango.inditex.store.shared.ids.ProductId;

public class ProductNotFoundException extends DomainException {
    private final ProductId productId;

    public ProductNotFoundException(ProductId productId) {
        this.productId = productId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
