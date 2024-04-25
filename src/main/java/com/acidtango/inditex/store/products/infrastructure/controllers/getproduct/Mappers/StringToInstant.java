package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers;

import java.time.Instant;

public class StringToInstant {
    public static Instant map(String date) {
        return Instant.parse(date);
    }
}
