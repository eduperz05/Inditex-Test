package com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.Mappers;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class InstantToString {
    public static String map(Instant date) {
        return DateTimeFormatter.ISO_INSTANT.format(date);
    }
}
