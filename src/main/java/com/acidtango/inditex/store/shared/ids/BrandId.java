package com.acidtango.inditex.store.shared.ids;

public class BrandId extends DomainId {
    public BrandId(Integer id) {
        super(id);
    }

    public static BrandId zara() {
        return new BrandId(1);
    }
}