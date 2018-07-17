package com.gaolei.Service;

import com.gaolei.Dao.ShopDao;
import com.gaolei.Entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Controller
@Transactional
public class ShopService  {
    @Autowired
    private ShopDao shopDao;

    public List<Shop> findAll(){
        return shopDao.findAll();
    }

    public void saveOrUpdate(Shop shop){
       shopDao.save(shop);
    }

    public  void deleteById(Integer id){
        shopDao.deleteById(id);
    }



}
