package com.gaolei.Action;

import com.gaolei.Entity.Shop;
import com.gaolei.Entity.Store;
import com.gaolei.Service.ShopService;
import com.gaolei.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by GaoLei on 2018/6/26.
 */
@Controller
@RequestMapping("/store")
public class StoreAction {

    @Autowired
    private StoreService storeService;
    @Autowired
    private ShopService shopService;
    /**
    * 添加商铺页
    * */
    @RequestMapping("add")
    private String add(){
        return "admin/add_store";
    }
    /**
    * 添加商铺信息
    * */
    @RequestMapping("addStore")
    public String addStore(HttpServletResponse response , HttpServletRequest request){
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String info  = request.getParameter("info");
        String tel = request.getParameter("tel");

        Store store = new Store() ;
        store.setName(name);
        store.setAddress(address);
        store.setInfo(info);
        store.setTel(Integer.valueOf(tel));

        storeService.saveOrUpdate(store);

        return  "admin/store_menu";
    }
   /**
   * 展示商铺信息
   * */
   @RequestMapping("index")
    public String index(Model model){
        List<Store>list = storeService.finAll();
        model.addAttribute("list",list);
        return "admin/store_list";
   }
    /**
     * 删除店铺
     * */
    @RequestMapping("del")
    public String del(){
        return "admin/store_del";
    }
    /**
     * 删除店铺信息
     * */
    @RequestMapping("delStore")
    public String delStore(HttpServletResponse  response ,HttpServletRequest request){
        String id  = request.getParameter("id");
        storeService.deleteById(Integer.valueOf(id));
        return "admin/store_menu";
    }
    /**
     * 跳转更新店铺数据页面
     * */
    @RequestMapping("update")
    public String update(){

        return "admin/store_update";
    }
    /**
     *
     * 更新店铺信息
     * */
    @RequestMapping("updateStore")
    public String updateStore(HttpServletResponse response,HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String info  = request.getParameter("info");
        String tel = request.getParameter("tel");

        Store store = new Store() ;
        store.setId(Integer.valueOf(id));
        store.setName(name);
        store.setAddress(address);
        store.setInfo(info);
        store.setTel(Integer.valueOf(tel));

        storeService.saveOrUpdate(store);

        return "admin/store_menu";
    }

    /**
     * 跳转店铺添加商品页面
     *
     * */
    @RequestMapping("addShop")
    public  String  addShop(){

        return "admin/store_addShop";
    }

    /**
     *
     * AddShop店铺添加商品
     * */
    @RequestMapping("addStoreShop")
    public String addStoreShop(HttpServletResponse  response, HttpServletRequest request){
        //店铺号
        String store_id = request.getParameter("store_id");
        //商品信息
        //  String shop_id = request.getParameter("shop_id");
        String info = request.getParameter("info");
        String name = request.getParameter("name");
        String price  = request.getParameter("price");
        String num = request.getParameter("num");

        Store  store = storeService.findByStoreId(Integer.valueOf(store_id));

        Shop shop = new Shop();
      //  shop.setId(Integer.valueOf(shop_id));mysql设置自增，所以没用
        shop.setInfo(info);
        shop.setName(name);
        shop.setPrice(Integer.valueOf(price));
        shop.setNum(Integer.valueOf(num));
        shop.setStore(store);
        shopService.saveOrUpdate(shop);
        return "admin/store_menu";
    }
    /**
     * Store_shop_menu展示店铺商品
     * */
    @RequestMapping("showShop")
    public  String  showShop(HttpServletResponse response ,HttpServletRequest request,Model model){
        String id  = request.getParameter("store_id");

        List<Store> list = storeService.findByShopList(Integer.valueOf(id));
        List<Shop> shopList = new ArrayList<Shop>();
        for (Store store:list){
                System.out.println(store.getName());
            for (Shop shop: store.getShops()) {
                System.out.println(shop.getName());
                shopList.add(shop);
            }
        }
        model.addAttribute("list",shopList);
        return "admin/showShop";
    }


}
