package com.gaolei.Action;

import com.gaolei.Entity.Admin;
import com.gaolei.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "index")
    public String index(Model model){
        List<Admin> list = adminService.findAll();
        model.addAttribute("list",list);
        return "admin/admin_list";
    }

    @RequestMapping(value = "save")
    public String save(Admin admin){
        admin.setName("root");
        admin.setPassword("gaolei");
        adminService.saveorUpdate(admin);
        return "index";
    }


}
