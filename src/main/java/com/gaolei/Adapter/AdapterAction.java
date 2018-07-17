package com.gaolei.Adapter;

import com.gaolei.Entity.Admin;
import com.gaolei.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by GaoLei on 2018/6/24.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdapterAction {

    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public String login(HashMap<String, Object> map) {
        map.put("hello","html");
        return "admin/login";
    }
    @RequestMapping( "dologin")
    public String login(HttpServletRequest request , HttpServletResponse response ){
        String name  = request.getParameter("name");
        String password = request.getParameter("password");
        Admin  admin = adminService.findByName(name);
        if(admin != null){
            if (null != admin.getName()) {
                if (password.equals(admin.getPassword())) {
                    //验证成功
                    return "success";
                }
                return "admin/pwd_err";
            }
        }
        return "admin/admin_null";
    }

    @RequestMapping("success")
    public String success()
    {

        return  "admin/success";

    }


    @RequestMapping("os")
    public String os(){

        return "admin/os";

    }
    /**
    * 关于我们
    * */
    @RequestMapping("about")
    public String about(){
        return "/admin/team";
    }
    /**
    * 管理商品
    * */
    @RequestMapping("shop_m")
    public  String shop_m(){
        return "admin/shop_manage";
    }
    /**
     * 管理店铺
     * */
    @RequestMapping("store_m")
    public String store_m(){

        return "admin/store_manage";
    }

    /**
     * 店铺管理
     * */
   @RequestMapping("store_menu")
    public String store_menu(){

        return "admin/store_menu";
    }
    /**
     * 商品管理
     * */
    @RequestMapping("shop_menu")
    public String shop_menu(){

        return "admin/shop_menu";
    }

    /**
     * 用户管理页面
     * */
    @RequestMapping("custom_menu")
    public String custom_menu(){
        return "admin/custom_menu";
    }

    /**
     *商品特色
     * */
    @RequestMapping("color")
    public String color(){
        return "admin/color";
    }

    /**
     * 使用帮助手册
     * */
    @RequestMapping("help")
    public String  help() {
        return "admin/help";

    }
}
