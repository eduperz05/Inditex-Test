package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct;

import com.acidtango.inditex.store.products.application.ObtainProduct;
import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO.GetProductRequest;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO.GetProductResponse;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers.GetProductRequestToProductCriteria;
import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers.TempProductToGetProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class GetProduct {

    final ObtainProduct obtainProduct;

    public GetProduct(ObtainProduct obtainProduct) {
        this.obtainProduct = obtainProduct;
    }

    @GetMapping
    @Operation(summary = "Obtains the effective schema.sql of a product")
    public ResponseEntity<GetProductResponse> index(@ParameterObject GetProductRequest getProductRequestDto) {
        TempProduct result = obtainProduct.execute(GetProductRequestToProductCriteria.map(getProductRequestDto));
        return ResponseEntity.ok(TempProductToGetProductResponse.map(result));
    }

}
