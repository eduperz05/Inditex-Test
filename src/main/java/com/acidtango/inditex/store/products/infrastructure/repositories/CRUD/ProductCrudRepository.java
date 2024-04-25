package com.acidtango.inditex.store.products.infrastructure.repositories.CRUD;

import com.acidtango.inditex.store.products.infrastructure.repositories.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer productId, Integer brandId, Instant startDate, Instant endDate);
}
