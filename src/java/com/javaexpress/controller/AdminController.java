package com.javaexpress.controller;

import com.javaexpress.bean.LoginBean;
import com.javaexpress.bean.RegisterStaffBean;
import com.javaexpress.dao.AdminDao;
import com.javaexpress.model.Admin;
import com.javaexpress.model.LevelAdmin;
import com.javaexpress.utils.PasswordDigest;
import java.util.Date;
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

        if (admin.getUsername() == null) {
            model.addAttribute("errMsg", "Username salah");
            return "index";
        }

        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if (!encryptedPassword.equals(admin.getPassword())) {
            model.addAttribute("errMsg", "Password salah");
            return "index";
        }

        if (admin.getLevel().getIdLevel() != levelAdmin.getIdLevel()) {
            model.addAttribute("errMsg", "Level Admin Tidak Cocok");
            return "index";
        } else {
            if (admin.getLevel().getIdLevel() == 1) {
                session.setAttribute("admin", admin);
                session.setAttribute("level", "master");

            } else if (admin.getLevel().getIdLevel() == 2) {
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

    @RequestMapping("/staff")
    public String dataStaff(Model model) {
        List<Admin> staff = ad.findAllStaff();
        model.addAttribute("staff", staff);
        return "dataStaff";
    }

    @RequestMapping("/input/staff")
    public String registerForm(Model model) {
        RegisterStaffBean registerBean = new RegisterStaffBean();
        List<LevelAdmin> levels = ad.tampilLevelAdmin();
        model.addAttribute("level", levels);
        model.addAttribute("registerBean", registerBean);
        return "registerStaff";
    }

    @RequestMapping("/input/staff/save")
    public String saveRegistration(HttpSession session, @ModelAttribute("registerBean") RegisterStaffBean registerBean,
            Model model) {
        Admin admin = new Admin();
        Admin master = (Admin) session.getAttribute("admin");

        String encryptedPassword = PasswordDigest.createEncryptedPassword(registerBean.getPassword());

        admin.setNamaLengkap(registerBean.getNama());
        admin.setUsername(registerBean.getUsername());
        admin.setPassword(encryptedPassword);
        admin.setLevel(ad.findLevelById(registerBean.getLevel()));
        admin.setCreatedBy(master);
        admin.setUpdatedBy(master);
        admin.setCreatedTime(new Date());
        admin.setUpdatedTime(new Date());
        admin.setStatus(ad.findStatusById(1));
        ad.saveAdmin(admin);
        model.addAttribute("data", registerBean);
        return "successRegister";
    }
    

}
