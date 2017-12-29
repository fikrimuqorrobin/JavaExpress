package com.javaexpress.controller;

import com.javaexpress.bean.LoginBean;
import com.javaexpress.dao.AdminDao;
import com.javaexpress.model.Admin;
import com.javaexpress.model.LevelAdmin;
import com.javaexpress.utils.PasswordDigest;
import java.util.List;
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
        List<LevelAdmin> levels = ad.tampilLevelAdmin();
        model.addAttribute("loginBean", loginBean);
        model.addAttribute("level", levels);
        return "index";
    }
    
    @RequestMapping("/check")
    public String checkLogin(HttpSession session, @ModelAttribute("loginBean") LoginBean loginBean, Model model) {
        Admin admin = ad.findByUsername(loginBean.getUsername());
        LevelAdmin levelAdmin = ad.findLevelById(loginBean.getLevel());
        
        List<LevelAdmin> levels = ad.tampilLevelAdmin();
        model.addAttribute("level", levels);
        
        if(admin.getUsername()==null) {
            model.addAttribute("errMsg", "Username salah");
            return "index";
        }
        
        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if(!encryptedPassword.equals(admin.getPassword())) {
            model.addAttribute("errMsg", "Password salah");
            return "index";
        }
        
        if(admin.getLevel().getIdLevel() != levelAdmin.getIdLevel()){
            model.addAttribute("errMsg", "Level Admin Tidak Cocok");
            return "index";
        } else {
            if(admin.getLevel().getIdLevel() == 1){
                session.setAttribute("admin", admin);
                session.setAttribute("level", "master");
            } else if(admin.getLevel().getIdLevel() == 2){
                session.setAttribute("admin", admin);
                session.setAttribute("level", "staff");
            }
            return "successLogin";
        }
    }
    
    @RequestMapping("/logout") 
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        //session.removeAttribute("user");
        return "redirect:/home";
    }
    
    
    
    
}
