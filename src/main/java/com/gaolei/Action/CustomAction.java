package com.gaolei.Action;

import com.gaolei.Entity.Custom;
import com.gaolei.Service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by GaoLei on 2018/6/24.
 */
@Controller
@RequestMapping("/custom")
public class CustomAction {
    @Autowired
    private CustomService customService;

    @RequestMapping(value = "index")
    public String index(Model model){
        List<Custom> list = customService.findAll();
        model.addAttribute("list",list);
        return "admin/custom_list";
    }



    @RequestMapping(value = "addCustom")
    public  String addCustom(HttpServletResponse response ,HttpServletRequest request ){

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String num =  request.getParameter("tel");
        HttpSession session = request.getSession(true);
        Custom custom = new Custom();
        custom.setName(name);
        custom.setPassword(password);
        custom.setAddress(address);

        custom.setTel(Integer.valueOf(num));
        customService.saveOrUpate(custom);
        return "admin/custom_menu";
    }

    @RequestMapping("delete")
    private String delete(HttpServletResponse response,HttpServletRequest request){

        String id = request.getParameter("id");
        if (id.isEmpty()){
            return "admin/404";
        }else {
            customService.delete(Integer.valueOf(id));
            return "admin/custom_menu";
        }
    }


}
