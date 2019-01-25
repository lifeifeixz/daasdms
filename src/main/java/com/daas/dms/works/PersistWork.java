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
package com.daas.dms.works;

/**
 * @author flysLi
 * @ClassName PersistWork
 * @Decription TODO
 * @Date 2019/1/25 17:22
 * @Version 1.0
 */
public interface PersistWork {

    /**
     * 在指定表名和缓存key的情况下持久化数据到db
     *
     * @param table
     * @param key
     */
    void insert(String table, String key);
}
