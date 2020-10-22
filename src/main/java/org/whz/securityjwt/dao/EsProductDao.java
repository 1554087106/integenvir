package org.whz.securityjwt.dao;

import org.springframework.stereotype.Repository;
import org.whz.securityjwt.nosql.elasticsearch.document.EsProduct;

import java.util.List;

@Repository
public class EsProductDao {
    public List<EsProduct> getAllEsProductList() {
        return null;
    };
    public List<EsProduct> getAllEsProductList(Long id) {
        return null;
    };
}