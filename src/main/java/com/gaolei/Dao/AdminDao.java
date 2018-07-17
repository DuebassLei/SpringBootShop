package com.gaolei.Dao;

import com.gaolei.Entity.Admin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Repository
public interface AdminDao extends CrudRepository<Admin,Integer> {
    @Query("from Admin")
    List<Admin> findAll();
    Admin findByName(String name);



}
