package com.gaolei.Action;

import com.gaolei.Entity.Shop;
import com.gaolei.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Controller
@RequestMapping("/shop")
public class ShopAction {
    @Autowired
    private ShopService shopService;
    /**
    * 获取商品信息列表
    * */
    @RequestMapping("index")
    public String index(Model model){
        List<Shop> list = shopService.findAll();
        model.addAttribute("list",list);
        return "admin/shop_list";
    }
    @RequestMapping("add")
    public String add(){
        return  "admin/add_shop";
    }
    /**
    * 添加商品
    * */
    @RequestMapping("addShop")
    public  String addShop(HttpServletResponse response , HttpServletRequest request){
        String info = request.getParameter("info");
        String name = request.getParameter("name");
        String price  = request.getParameter("price");
        String num = request.getParameter("num");

        Shop shop = new Shop();

        shop.setInfo(info);
        shop.setName(name);
        shop.setPrice(Integer.valueOf(price));
        shop.setNum(Integer.valueOf(num));
        shopService.saveOrUpdate(shop);

        return "admin/shop_menu";
    }
    /**
    * 删除商品
    * */
    @RequestMapping("del")
    public  String  del(){
        return "admin/shop_del";
    }

    /**
    * 删除商品
    * */

    @RequestMapping("delShop")
    public String delShop(HttpServletResponse response,HttpServletRequest request){
        String id = request .getParameter("id");
        shopService.deleteById(Integer.valueOf(id));
        return "admin/shop_menu";
    }

    /**
     * 更新商品页面
     * */

    @RequestMapping("update")
    public String update(){

        return "admin/shop_update";
    }

    /**
     * 更新商品信息
     * */
    @RequestMapping("updateShop")
    public String updateShop(HttpServletResponse response ,HttpServletRequest request){
        String id = request.getParameter("id");
        String info = request.getParameter("info");
        String name = request.getParameter("name");
        String price  = request.getParameter("price");
        String num = request.getParameter("num");

        Shop shop = new Shop();
        shop.setId(Integer.valueOf(id));
        shop.setInfo(info);
        shop.setName(name);
        shop.setPrice(Integer.valueOf(price));
        shop.setNum(Integer.valueOf(num));
        shopService.saveOrUpdate(shop);
        return "admin/shop_menu";
    }





}
