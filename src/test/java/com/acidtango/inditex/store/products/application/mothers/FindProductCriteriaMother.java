package com.acidtango.inditex.store.products.application.mothers;

import com.acidtango.inditex.store.products.domain.criteria.FindProductCriteria;
import com.acidtango.inditex.store.shared.ids.BrandId;
import com.acidtango.inditex.store.shared.ids.ProductId;

import java.time.Instant;

public class FindProductCriteriaMother {

    public static FindProductCriteria create(Integer productId, Integer brandId, String applicationDate) {
        return new FindProductCriteria(
                new ProductId(productId),
                new BrandId(brandId),
                Instant.parse(applicationDate)
        );
    }
}
