package com.javaexpress.controller;

import com.javaexpress.bean.LoginBean;
import com.javaexpress.dao.AdminDao;
import com.javaexpress.model.Admin;
import com.javaexpress.utils.PasswordDigest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class AdminController {
    
    @Autowired
    AdminDao ad;

    @RequestMapping()
    public String halamanIndex(Model model) {
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "index";
    }
    
    @RequestMapping(value = "/check")
    public String checkLogin(HttpSession session, @ModelAttribute("loginBean") LoginBean loginBean, Model model) {
        Admin admin = ad.findByUsername(loginBean.getUsername());
        if(admin.getUsername()==null) {
            model.addAttribute("errMsg", "Username salah");
            return "index";
        }
        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if(!encryptedPassword.equals(admin.getPassword())) {
            model.addAttribute("errMsg", "Password salah");
            return "index";
        }
        
        session.setAttribute("admin", admin);
        model.addAttribute("errMsg", "SUKSES");
        return "index";
    }
}
