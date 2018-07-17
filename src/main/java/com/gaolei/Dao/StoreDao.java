package com.gaolei.Dao;

import com.gaolei.Entity.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Repository
public interface  StoreDao extends CrudRepository<Store,Integer> {
    @Query("from Store")
     List<Store> findAll();

    @Query("select s from Store s where s.id = ?1")
    Store findByStoreId(Integer id);
    //select distinct d from Dept d inner join  d.emps
    @Query("select distinct s from Store s inner join s.shops where s.id = ?1")
    List<Store> findByShopList(Integer id);


}
