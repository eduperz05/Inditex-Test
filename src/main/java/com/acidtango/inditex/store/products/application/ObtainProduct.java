package com.acidtango.inditex.store.products.application;

import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.domain.criteria.FindProductCriteria;
import com.acidtango.inditex.store.products.domain.exceptions.ProductNotFoundException;
import com.acidtango.inditex.store.products.domain.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ObtainProduct {
    private final ProductRepository productRepository;

    public ObtainProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public TempProduct execute(FindProductCriteria productCriteria) {
        return productRepository.find(productCriteria)
                .stream()
                .max(Comparator.comparingInt(TempProduct::getPriority))
                .orElseThrow(() -> new ProductNotFoundException(productCriteria.productId()));
    }
}
