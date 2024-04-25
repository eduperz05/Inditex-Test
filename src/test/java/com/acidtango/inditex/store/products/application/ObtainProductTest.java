package com.acidtango.inditex.store.products.application;

import com.acidtango.inditex.store.products.application.mothers.FindProductCriteriaMother;
import com.acidtango.inditex.store.products.application.mothers.TempProductMother;
import com.acidtango.inditex.store.products.domain.Currency;
import com.acidtango.inditex.store.products.domain.exceptions.ProductNotFoundException;
import com.acidtango.inditex.store.products.domain.primitives.ProductPrimitives;
import com.acidtango.inditex.store.products.domain.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


class ObtainProductTest {
    private final ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);

    @Test
    @DisplayName("Execute receives a product criteria and returns the product with the correct price and duration")
    void test1() {
        // Given
        var obtainProduct = new ObtainProduct(productRepositoryMock);
        var productCriteria = FindProductCriteriaMother.create(
                35455,
                1,
                "2020-06-14T10:00:00.000Z");
        var product1 = TempProductMother.create(
                35455,
                1,
                1,
                0,
                35.50,
                Currency.EUR,
                "2020-06-14T00:00:00Z",
                "2020-12-31T23:59:59Z"
        );
        var product2 = TempProductMother.create(
                35455,
                1,
                2,
                1,
                25.50,
                Currency.EUR,
                "2020-06-14T15:00:00Z",
                "2020-06-14T18:30:00Z"
        );

        // When
        when(productRepositoryMock.find(productCriteria)).thenReturn(List.of(product1, product2));
        ProductPrimitives tempProduct = obtainProduct.execute(productCriteria).toPrimitives();

        // Then
        Mockito.verify(productRepositoryMock, Mockito.times(1)).find(productCriteria);
        assertThat(tempProduct.id()).isEqualTo(35455);
        assertThat(tempProduct.brandId()).isEqualTo(1);
        assertThat(tempProduct.price().id()).isEqualTo(2);
        assertThat(tempProduct.price().price()).isEqualTo(25.50);
        assertThat(tempProduct.price().currency()).isEqualTo(Currency.EUR);
        assertThat(tempProduct.price().startDate()).isEqualTo(Instant.parse("2020-06-14T15:00:00Z"));
        assertThat(tempProduct.price().endDate()).isEqualTo(Instant.parse("2020-06-14T18:30:00Z"));
        assertThat(tempProduct.price().priority()).isEqualTo(1);

    }

    @Test
    @DisplayName("Execute receives a product criteria and throws an exception when no product is found")
    void test2() {
        // Given
        var obtainProduct = new ObtainProduct(productRepositoryMock);
        var productCriteria = FindProductCriteriaMother.create(
                35455,
                1,
                "2020-06-14T10:00:00.000Z");

        // When
        when(productRepositoryMock.find(productCriteria)).thenReturn(List.of());
        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
            obtainProduct.execute(productCriteria);
        });

        // Then
        Mockito.verify(productRepositoryMock, Mockito.times(1)).find(productCriteria);
        assertThat(productCriteria.productId()).isEqualTo(exception.getProductId());
    }
}