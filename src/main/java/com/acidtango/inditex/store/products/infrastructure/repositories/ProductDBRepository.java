package com.acidtango.inditex.store.products.infrastructure.repositories;

import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.domain.criteria.FindProductCriteria;
import com.acidtango.inditex.store.products.domain.repositories.ProductRepository;
import com.acidtango.inditex.store.products.infrastructure.repositories.CRUD.ProductCrudRepository;
import com.acidtango.inditex.store.products.infrastructure.repositories.entities.ProductEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDBRepository implements ProductRepository {
    private final ProductCrudRepository productRepository;

    public ProductDBRepository(ProductCrudRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<TempProduct> find(FindProductCriteria productCriteria) {
        return productRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productCriteria.productId().getId(),
                productCriteria.brandId().getId(),
                productCriteria.applicationDate(),
                productCriteria.applicationDate())
                .stream().map(ProductEntityMapper::mapToDomain).toList();
    }
}
