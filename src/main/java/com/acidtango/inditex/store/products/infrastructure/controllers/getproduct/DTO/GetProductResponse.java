package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record GetProductResponse(
        @Schema(description = "The product id")
        Integer productId,

        @Schema(description = "The brand id")
        Integer brandId,

        @Schema(description = "Brand Name")
        String brandName,

        @Schema(description = "The schema.sql fee id to be applied")
        Integer priceId,

        @Schema(description = "Start date to filter the schema.sql list")
        String startDate,

        @Schema(description = "End date to filter the schema.sql list")
        String endDate,

        @Schema(description = "Final schema.sql of the product")
        Double price
) {
}
