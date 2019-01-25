/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.daas.dms.dao;

import com.daas.dms.beans.Product;
import com.daas.dms.beans.dto.SellerPriceTrendDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author flysLi
 * @ClassName ProductMapper
 * @Decription TODO
 * @Date 2018/12/14 13:57
 * @Version 1.0
 */
@Mapper
public interface ProductMapper {
    List<Product> findSellerAll(String date);

    List<Product> findSellerPrice(@Param("name") String name, @Param("date") String date);

    List<Product> findSellerPriceTrend(SellerPriceTrendDto dto);
}
