package com.acidtango.inditex.store.products.infrastructure.controllers;

import com.acidtango.inditex.store.products.infrastructure.controllers.getproduct.DTO.GetProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GetProductTest {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test1() {
        GetProductResponse product = given()
                .port(port)
                .when()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T10:00:00.000Z")
                .get("/product")
                .getBody()
                .as(GetProductResponse.class);


        assertThat(product.productId()).isEqualTo(35455);
        assertThat(product.brandId()).isEqualTo(1);
        assertThat(product.priceId()).isEqualTo(1);
        assertThat(product.startDate()).isEqualTo("2020-06-14T00:00:00Z");
        assertThat(product.endDate()).isEqualTo("2020-12-31T23:59:59Z");
        assertThat(product.price()).isEqualTo(35.50);

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test2() {
        GetProductResponse product = given()
                .port(port)
                .when()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T16:00:00.000Z")
                .get("/product")
                .getBody()
                .as(GetProductResponse.class);

        assertThat(product.productId()).isEqualTo(35455);
        assertThat(product.brandId()).isEqualTo(1);
        assertThat(product.priceId()).isEqualTo(2);
        assertThat(product.startDate()).isEqualTo("2020-06-14T15:00:00Z");
        assertThat(product.endDate()).isEqualTo("2020-06-14T18:30:00Z");
        assertThat(product.price()).isEqualTo(25.45);
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test3() {
        GetProductResponse product = given()
                .port(port)
                .when()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T21:00:00.000Z")
                .get("/product")
                .getBody()
                .as(GetProductResponse.class);

        assertThat(product.productId()).isEqualTo(35455);
        assertThat(product.brandId()).isEqualTo(1);
        assertThat(product.priceId()).isEqualTo(1);
        assertThat(product.startDate()).isEqualTo("2020-06-14T00:00:00Z");
        assertThat(product.endDate()).isEqualTo("2020-12-31T23:59:59Z");
        assertThat(product.price()).isEqualTo(35.50);
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void test4() {
        GetProductResponse product = given()
                .port(port)
                .when()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-15T10:00:00.000Z")
                .get("/product")
                .getBody()
                .as(GetProductResponse.class);

        assertThat(product.productId()).isEqualTo(35455);
        assertThat(product.brandId()).isEqualTo(1);
        assertThat(product.priceId()).isEqualTo(3);
        assertThat(product.startDate()).isEqualTo("2020-06-15T00:00:00Z");
        assertThat(product.endDate()).isEqualTo("2020-06-15T11:00:00Z");
        assertThat(product.price()).isEqualTo(30.50);
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void test5() {
        GetProductResponse product = given()
                .port(port)
                .when()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-16T21:00:00.000Z")
                .get("/product")
                .getBody()
                .as(GetProductResponse.class);

        assertThat(product.productId()).isEqualTo(35455);
        assertThat(product.brandId()).isEqualTo(1);
        assertThat(product.priceId()).isEqualTo(4);
        assertThat(product.startDate()).isEqualTo("2020-06-15T16:00:00Z");
        assertThat(product.endDate()).isEqualTo("2020-12-31T23:59:59Z");
        assertThat(product.price()).isEqualTo(38.95);
    }
}
