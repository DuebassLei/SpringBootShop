package com.gaolei.Service;

import com.gaolei.Dao.StoreDao;
import com.gaolei.Entity.Shop;
import com.gaolei.Entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Controller
@Transactional
public class StoreService {
    @Autowired
    private StoreDao storeDao;

    public void  saveOrUpdate(Store store){
        storeDao.save(store);

    }
    public List<Store>finAll(){

        return storeDao.findAll();

    }
    public  void deleteById(Integer id) {

        storeDao.deleteById(id);
    }

   public  Store findByStoreId(Integer id){
        return   storeDao.findByStoreId(id);

    }

    /**
     * 展示商店商品
     * */
    public List<Store> findByShopList(Integer id){
        return  storeDao.findByShopList(id);
    }



}
