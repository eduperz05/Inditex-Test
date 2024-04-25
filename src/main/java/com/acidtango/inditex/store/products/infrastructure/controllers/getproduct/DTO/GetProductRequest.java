package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record GetProductRequest(
        @Schema(description = "The product id")
        Integer productId,

        @Schema(description = "The brand id")
        Integer brandId,

        @Schema(description = "Date to filter the schema.sql list")
        String applicationDate
) {
}
