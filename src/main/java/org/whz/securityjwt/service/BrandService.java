package org.whz.securityjwt.service;

import org.whz.securityjwt.model.PmsBrand;

import java.util.List;

public interface BrandService {
    List<PmsBrand> queryAll();
}