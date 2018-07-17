package com.gaolei.Dao;

import com.gaolei.Entity.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Repository
public interface ShopDao extends CrudRepository<Shop,Integer> {
    @Query("from Shop")
     List<Shop> findAll();




}
