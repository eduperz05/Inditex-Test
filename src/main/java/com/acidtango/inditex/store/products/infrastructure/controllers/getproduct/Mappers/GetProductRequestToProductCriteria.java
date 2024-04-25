package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers;

import com.acidtango.inditex.store.products.domain.criteria.FindProductCriteria;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO.GetProductRequest;
import com.acidtango.inditex.store.shared.ids.BrandId;
import com.acidtango.inditex.store.shared.ids.ProductId;

public class GetProductRequestToProductCriteria {
    public static FindProductCriteria map(GetProductRequest request) {
        return new FindProductCriteria(
                new ProductId(request.productId()),
                new BrandId(request.brandId()),
                StringToInstant.map(request.applicationDate())
        );
    }
}
