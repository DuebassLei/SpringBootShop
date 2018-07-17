package com.gaolei.Service;

import com.gaolei.Dao.CustomDao;

import com.gaolei.Entity.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Service
@Transactional
public class CustomService {
    @Autowired
    private CustomDao customDao;

    public  void saveOrUpate(Custom custom){
        customDao.save(custom);
    }

    @Transactional(readOnly = true)
    public List<Custom> findAll(){

        return customDao.findAll();

    }

    public  void findById(Integer id){

        customDao.findById(id);
    }

    public void delete(Integer id){
      customDao.deleteById(id);
    }


}
