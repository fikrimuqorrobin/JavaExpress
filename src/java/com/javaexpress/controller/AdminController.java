package com.javaexpress.controller;

import com.javaexpress.bean.LoginBean;
import com.javaexpress.bean.ProfileBean;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    AdminDao ad;

    @RequestMapping()
    public String halamanIndex(Model model) {
        LoginBean loginBean = new LoginBean();
        List<LevelAdmin> levels = ad.tampilLevelAdmin();
        model.addAttribute("loginBean", loginBean);
        model.addAttribute("level", levels);
        model.addAttribute("file", "beranda.jsp");
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
        
        if(admin.getStatus().getIdStatus() == 2){
            model.addAttribute("errMsg", "Maaf Data Anda Sudah Tidak Aktif");
            return "index";
        } 
        
        if(admin.getLevel().getIdLevel() != levelAdmin.getIdLevel()){
            model.addAttribute("errMsg", "Level Admin Tidak Cocok");
            return "index";
        } else {
            if(admin.getLevel().getIdLevel() == 1){
                session.setAttribute("admin", admin);
                session.setAttribute("level", "master");
                model.addAttribute("file", "beranda.jsp");
            } else if(admin.getLevel().getIdLevel() == 2){
                session.setAttribute("admin", admin);
                session.setAttribute("level", "staff");
                model.addAttribute("file", "beranda.jsp");
            }
            return "index";
        }
    }
    
    @RequestMapping("/logout") 
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        //session.removeAttribute("user");
        return "redirect:/admin";
    }
    
    @RequestMapping("/staff")
    public String dataStaff(Model model){
        List<Admin> staff = ad.findAllStaff();
        model.addAttribute("file", "dataStaff.jsp");
        model.addAttribute("staff", staff);
        return "index";
    }
        
    @RequestMapping("/input/staff") 
    public String registerForm(Model model) {
        RegisterStaffBean registerBean = new RegisterStaffBean();
        List<LevelAdmin> levels = ad.tampilLevelAdmin();
        model.addAttribute("level", levels);
        model.addAttribute("registerBean", registerBean);
        model.addAttribute("file", "registerStaff.jsp");
        return "index";
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
        admin.setLevel(ad.findLevelById(2));
        admin.setCreatedBy(master);
        admin.setUpdatedBy(master);
        admin.setCreatedTime(new Date());
        admin.setUpdatedTime(new Date());
        admin.setStatus(ad.findStatusById(1));
        ad.saveAdmin(admin);
        model.addAttribute("data", registerBean);
        return "successRegister";
    }
    
    @RequestMapping("/profil/{idAdmin}")
    public String myProfile(@PathVariable Integer idAdmin ,Model model){
        Admin admin = ad.findAdminById(idAdmin);
        ProfileBean profileBean = new ProfileBean();
        model.addAttribute("profilBean", profileBean);
        model.addAttribute("file", "profil.jsp");
        model.addAttribute("admin", admin);
        return "index";
    }
        
    @RequestMapping("/profil/update/Master/{adminId}") 
    public String saveUpdateProfil(HttpSession session, @ModelAttribute("profilBean") ProfileBean profilBean, 
            Model model, @PathVariable Integer adminId) {
        //Admin master = (Admin) session.getAttribute("admin");
        Admin master = ad.findAdminById(adminId);
        String encryptedPassword = PasswordDigest.createEncryptedPassword(profilBean.getPassword());
        master.setNamaLengkap(profilBean.getNama());
        master.setUsername(profilBean.getUsername());
        master.setPassword(encryptedPassword);
        master.setUpdatedBy(master);
        master.setUpdatedTime(new Date());
        ad.updateAdmin(master);
        return "successRegister";
    }
    
    @RequestMapping("/profil/update/Staff/{staffId}") 
    public String saveUpdateStaff(HttpSession session, @ModelAttribute("profilBean") ProfileBean profilBean, 
            Model model, @PathVariable Integer staffId) {
        Admin staff = ad.findAdminById(staffId);
        Admin master = (Admin) session.getAttribute("admin");
        String encryptedPassword = PasswordDigest.createEncryptedPassword(profilBean.getPassword());
        staff.setNamaLengkap(profilBean.getNama());
        staff.setUsername(profilBean.getUsername());
        staff.setPassword(encryptedPassword);
        staff.setUpdatedBy(master);
        staff.setUpdatedTime(new Date());
        ad.updateAdmin(staff);
        return "successRegister";
    }
    
    @RequestMapping("/hapus/staff/{staffId}")
    public String hapusStaff(Model model, HttpSession session, @PathVariable Integer staffId){
        Admin staff = ad.findAdminById(staffId);
        Admin master = (Admin) session.getAttribute("admin");
        staff.setStatus(ad.findStatusById(2));
        staff.setUpdatedBy(master);
        staff.setUpdatedTime(new Date());
        ad.hapusStaff(staff);
        return "successRegister";
    }
    
    
}
