package com.acidtango.inditex.store.products.domain.repositories;

import com.acidtango.inditex.store.products.domain.TempProduct;
import com.acidtango.inditex.store.products.domain.criteria.FindProductCriteria;

import java.util.List;

public interface ProductRepository {
    List<TempProduct> find(FindProductCriteria productCriteria);
}
