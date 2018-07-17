package com.gaolei.Dao;

import com.gaolei.Entity.Custom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Repository
public interface CustomDao extends CrudRepository<Custom,Integer> {
        @Query("from Custom")
    public List<Custom> findAll();
}
