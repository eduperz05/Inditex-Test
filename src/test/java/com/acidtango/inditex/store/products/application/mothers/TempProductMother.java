package com.acidtango.inditex.store.products.application.mothers;

import com.acidtango.inditex.store.products.domain.Currency;
import com.acidtango.inditex.store.products.domain.Duration;
import com.acidtango.inditex.store.products.domain.ProductPrice;
import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.shared.ids.BrandId;
import com.acidtango.inditex.store.shared.ids.PriceId;
import com.acidtango.inditex.store.shared.ids.ProductId;

import java.time.Instant;

public class TempProductMother {

    public static TempProduct create(Integer productId, Integer brandId, Integer priceList, Integer priority, Double price, Currency currency, String startDate, String endDate) {
        return new TempProduct(
                new ProductId(productId),
                new BrandId(brandId),
                new ProductPrice(
                        new PriceId(priceList),
                        new Duration(
                                Instant.parse(startDate),
                                Instant.parse(endDate)
                        ),
                        priority,
                        price,
                        currency
                )
        );
    }
}
