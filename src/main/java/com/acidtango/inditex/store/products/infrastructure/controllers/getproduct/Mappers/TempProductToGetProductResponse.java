package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers;

import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO.GetProductResponse;
import com.acidtango.inditex.store.shared.ids.BrandId;

public class TempProductToGetProductResponse {
    public static GetProductResponse map(TempProduct request) {
        return new GetProductResponse(
                request.toPrimitives().id(),
                request.toPrimitives().brandId(),
                BrandId.zara().toString(),
                request.toPrimitives().price().id(),
                InstantToString.map(request.toPrimitives().price().startDate()),
                InstantToString.map(request.toPrimitives().price().endDate()),
                request.toPrimitives().price().price()

        );
    }
}
