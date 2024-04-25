package com.acidtango.inditex.store.products.domain.criteria;

import com.acidtango.inditex.store.shared.ids.BrandId;
import com.acidtango.inditex.store.shared.ids.ProductId;

import java.time.Instant;

public record FindProductCriteria(
        ProductId productId,
        BrandId brandId,
        Instant applicationDate
) {
}
