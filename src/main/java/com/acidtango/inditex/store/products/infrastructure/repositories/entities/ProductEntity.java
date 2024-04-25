package com.acidtango.inditex.store.products.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "BRAND_ID")
    Integer brandId;

    @Column(name = "START_DATE")
    Instant startDate;

    @Column(name = "END_DATE")
    Instant endDate;

    @Column(name = "PRICE_LIST")
    Integer priceList;

    @Column(name = "PRODUCT_ID")
    Integer productId;

    @Column(name = "PRIORITY")
    Integer priority;

    @Column(name = "PRICE")
    Double price;

    @Column(name = "CURRENCY")
    String currency;
}


