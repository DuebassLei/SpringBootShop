package com.gaolei.Service;

import com.gaolei.Dao.AdminDao;
import com.gaolei.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public  void  saveorUpdate(Admin admin){

        adminDao.save(admin);

    }

    @Transactional(readOnly = true)
    public List<Admin> findAll(){
        return adminDao.findAll();
    }

    public Admin findByName(String name){

      return   adminDao.findByName(name);
    }
}
