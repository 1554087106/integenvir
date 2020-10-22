package org.whz.securityjwt.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.whz.securityjwt.dao.EsProductDao;
import org.whz.securityjwt.nosql.elasticsearch.document.EsProduct;
import org.whz.securityjwt.nosql.elasticsearch.repository.EsProductRepository;
import org.whz.securityjwt.service.EsProductService;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductRepository productRepository;
    @Autowired
    private EsProductDao productDao;

    /**
     * 返回导入商品的数量
     * @return
     */
    @Override
    public int importAll() {
        List<EsProduct> allEsProductList = productDao.getAllEsProductList();
        Iterable<EsProduct> esProductsList = productRepository.saveAll(allEsProductList);
        Iterator<EsProduct> iterator = esProductsList.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result ++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> allEsProductList = productDao.getAllEsProductList();
        if(allEsProductList.size() > 0) {
            EsProduct esProduct = allEsProductList.get(0);
            EsProduct save = productRepository.save(esProduct);
        }
        return null;
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = Lists.newArrayList();
            for(Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}