package com.daas.dms.dao;


import com.daas.dms.beans.Variety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by flysLi on 2018/12/28.
 */
@Repository
public interface VarietyRepository extends JpaRepository<Variety, Integer> {

    Variety findByCode(String code);

    List<Variety> findByParentId(Integer parentId);

    Variety findByName(String name);
}
