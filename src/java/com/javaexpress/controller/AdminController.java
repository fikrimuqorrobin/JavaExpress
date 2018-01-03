package com.javaexpress.controller;

import com.javaexpress.DAO.KotaDAO;
import com.javaexpress.DAO.PengirimanDao;
import com.javaexpress.DAO.TarifDao;
import com.javaexpress.DAO.TrackingDao;
import com.javaexpress.Taglib.FormPengiriman;
import com.javaexpress.Taglib.FormTarif;
import com.javaexpress.Taglib.FormTracking;
import com.javaexpress.bean.LoginBean;
import com.javaexpress.bean.ProfileBean;
import com.javaexpress.bean.RegisterStaffBean;
import com.javaexpress.DAO.AdminDao;
import com.javaexpress.model.Admin;
import com.javaexpress.model.Kota;
import com.javaexpress.model.LevelAdmin;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import com.javaexpress.utils.PasswordDigest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminDao ad;
    
    Logger log = Logger.getLogger(AdminController.class.getName());
    private FileHandler fh;

    public void FileHandler() throws IOException {
        this.fh = new FileHandler("C:\\Users\\user\\Desktop\\Logging\\LoggingCourierService.log", true);
    }

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

        if (admin.getUsername() == null) {
            model.addAttribute("errMsg", "Username salah");
            return "index";
        }

        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if (!encryptedPassword.equals(admin.getPassword())) {
            model.addAttribute("errMsg", "Password salah");
            return "index";
        }

        if (admin.getStatus().getIdStatus() == 2) {
            model.addAttribute("errMsg", "Maaf Data Anda Sudah Tidak Aktif");
            return "index";
        }

        if (admin.getLevel().getIdLevel() != levelAdmin.getIdLevel()) {
            model.addAttribute("errMsg", "Level Admin Tidak Cocok");
            return "index";
        } else {
            if (admin.getLevel().getIdLevel() == 1) {
                session.setAttribute("admin", admin);
                session.setAttribute("level", "master");
                model.addAttribute("file", "beranda.jsp");
            } else if (admin.getLevel().getIdLevel() == 2) {
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
    public String dataStaff(Model model) {
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
    public String myProfile(@PathVariable Integer idAdmin, Model model) {
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
    public String hapusStaff(Model model, HttpSession session, @PathVariable Integer staffId) {
        Admin staff = ad.findAdminById(staffId);
        Admin master = (Admin) session.getAttribute("admin");
        staff.setStatus(ad.findStatusById(2));
        staff.setUpdatedBy(master);
        staff.setUpdatedTime(new Date());
        ad.hapusStaff(staff);
        return "successRegister";
    }

    @RequestMapping(value = "/{username}")
    public String tampilAdmin(Model model) {
        return "index";
    }

    @RequestMapping(value = "/test")
    public String test(Model model) {
       KotaDAO kd = new KotaDAO();
        try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Test pada kelas " + kd.ListKota());

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }

        model.addAttribute("list", kd.ListKota());
        return "test";
    }

    @RequestMapping(value = "insertTarif")
    public String insertDataTarif(Model model, @ModelAttribute("ft") FormTarif formTarif) {
        KotaDAO kd = new KotaDAO();
        try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Insert Tarif");

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }
        List<String> kotaAsal = new ArrayList<>();
        List<String> kotaTujuan = new ArrayList<>();
        for (Kota kota : kd.ListKota()) {
            kotaAsal.add(kota.getNamaKota());
        }

        for (Kota kota : kd.ListKota()) {
            kotaTujuan.add(kota.getNamaKota());
        }
        model.addAttribute("kotaAsal", kotaAsal);
        model.addAttribute("kotaTujuan", kotaTujuan);
        return "insertTarif";
    }

    @RequestMapping("insertTr")
    public String insertData(Model model, @ModelAttribute("ft") FormTarif formTarif) {
       KotaDAO kd = new KotaDAO();
       try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Test pada kelas " + kd.ListKota());

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }
        List<String> kotaAsal = new ArrayList<>();
        List<String> kotaTujuan = new ArrayList<>();
        for (Kota kota : kd.ListKota()) {
            kotaAsal.add(kota.getNamaKota());
        }

        for (Kota kota : kd.ListKota()) {
            kotaTujuan.add(kota.getNamaKota());
        }
        model.addAttribute("kotaAsal", kotaAsal);
        model.addAttribute("kotaTujuan", kotaTujuan);

     
        Kota kodeKotaAsal = kd.SelectKota(formTarif.getKotaAsal());
        Kota kodeKotaTujuan = kd.SelectKota(formTarif.getKotaTujuan());

        TarifDao td = new TarifDao();
        td.InsertDataTarif(kodeKotaAsal, kodeKotaTujuan, formTarif.getTarifReguler(),
                formTarif.getTarifKilat(), formTarif.getTarifOns(), formTarif.getTarifSds(), formTarif.getTarifHds());
        
        return "insertTarif";
    }

    @RequestMapping("SelectPengiriman")
    public String updatePengiriman(Model model) {
        PengirimanDao pdao = new PengirimanDao();
        List<Pengiriman> lp = new ArrayList<>();
        lp = pdao.allListPengiriman();
        for (Pengiriman p : lp) {
            p.getIdPengiriman();
            p.getNamaPenerima();
            p.getNamaPengirim();
            p.getAlamatPenerima();
            p.getKotaPenerima().getNamaKota();
            p.getNoResi();
            p.getNamaPaket();
            p.getTotalTarif();
            p.getStatus().getStatus();
        }
        model.addAttribute("list", lp);

        // Logging untuk Select Pengiriman
        try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Select Pengiriman " + lp);

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }

        // Logging untuk Select Pengiriman 
        return "SelectPengiriman";
    }

    @RequestMapping(value = "StatusPengiriman")
    public String StatusPengiriman(Model model, @RequestParam("status") String Status, @RequestParam("ID") int ID) {
        PengirimanDao pdao = new PengirimanDao();
        if (Status.equalsIgnoreCase("Tidak Aktif")) {
            pdao.UpdateDatabasePengiriman(ID, new Status(2));
        }
        if (Status.equalsIgnoreCase("Aktif")) {
            pdao.UpdateDatabasePengiriman(ID, new Status(1));
        }
        List<Pengiriman> lp = new ArrayList<>();
        lp = pdao.allListPengiriman();
        for (Pengiriman p : lp) {
            p.getIdPengiriman();
            p.getNamaPenerima();
            p.getNamaPengirim();
            p.getAlamatPenerima();
            p.getKotaPenerima().getNamaKota();
            p.getNoResi();
            p.getNamaPaket();
            p.getTotalTarif();
            p.getStatus().getStatus();
        }
        
         try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Update Status Pengiriman pada ID " + ID);

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }
     
        
        model.addAttribute("list", lp);

        //Logging
        try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Select Pengiriman " + lp);

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }

        //Logging
        return "SelectPengiriman";
    }

    @RequestMapping("InsertPengiriman")
    public String insertPengiriman(Model model, @ModelAttribute("fp") FormPengiriman formPengiriman) {
       KotaDAO kd = new KotaDAO();
        List<String> kotaAsal = new ArrayList<>();
        List<String> kotaTujuan = new ArrayList<>();
        for (Kota kota : kd.ListKota()) {
            kotaAsal.add(kota.getNamaKota());
        }

        for (Kota kota : kd.ListKota()) {
            kotaTujuan.add(kota.getNamaKota());
        }
        List<String> jenisLayanan = new ArrayList<>();
        jenisLayanan.add("Reguler");
        jenisLayanan.add("Kilat");
        jenisLayanan.add("ONS");
        jenisLayanan.add("SDS");
        jenisLayanan.add("HDS");
        model.addAttribute("kotaAsal", kotaAsal);
        model.addAttribute("kotaTujuan", kotaTujuan);
        model.addAttribute("jenisLayanan", jenisLayanan);
        
        
           
         try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Insert Pengiriman ");

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }
        
        return "insertPengiriman";
        
     
    }

    @RequestMapping("InsertP")
    public String insertP(Model model, @ModelAttribute("fp") FormPengiriman formPengiriman) {
     KotaDAO kd = new KotaDAO();
        List<String> kotaAsal = new ArrayList<>();
        List<String> kotaTujuan = new ArrayList<>();
        for (Kota kota : kd.ListKota()) {
            kotaAsal.add(kota.getNamaKota());
        }

        for (Kota kota : kd.ListKota()) {
            kotaTujuan.add(kota.getNamaKota());
        }
        List<String> jenisLayanan = new ArrayList<>();
        jenisLayanan.add("Reguler");
        jenisLayanan.add("Kilat");
        jenisLayanan.add("ONS");
        jenisLayanan.add("SDS");
        jenisLayanan.add("HDS");
        model.addAttribute("kotaAsal", kotaAsal);
        model.addAttribute("kotaTujuan", kotaTujuan);

        model.addAttribute("jenisLayanan", jenisLayanan);


        Kota KotaPenerima = kd.SelectKota(formPengiriman.getKotaPenerima());
        Kota KotaPengirim = kd.SelectKota(formPengiriman.getKotaPengirim());

        String noResi = null;
        Timestamp x = new Timestamp(new Date().getTime());
        noResi = KotaPenerima.getKodeKota() + "A" + x.getTime() + "B" + KotaPengirim.getKodeKota();
        PengirimanDao pdao = new PengirimanDao();
        TarifDao tdao = new TarifDao();
        int idTarif = tdao.idTarif(KotaPenerima, KotaPengirim);
        pdao.InsertDatabasePengiriman(formPengiriman.getAlamatPenerima(), formPengiriman.getAlamatPengirim(), formPengiriman.getAsuransi(),
                formPengiriman.getBeratBarang(), formPengiriman.getHargaBarang(), formPengiriman.getJenisLayanan(), formPengiriman.getNamaPaket(),
                formPengiriman.getNamaPenerima(), formPengiriman.getNamaPengirim(), noResi, formPengiriman.getTeleponPenerima(), formPengiriman.getTeleponPengirim(),
                formPengiriman.getTipePaket(), KotaPenerima, KotaPengirim, idTarif);
        TrackingDao trackdao = new TrackingDao();
        trackdao.insertDatabaseTracking(noResi, "Dalam Masa Pengiriman");

           try {
            FileHandler();
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Insert pada data dengan no Resi = " + noResi );

        } catch (IOException ex) {

        } catch (SecurityException ex) {

        }
        
        return "insertPengiriman";
        
      
    }
   

    @RequestMapping("insertTracking")
    public String insertTracking(Model model, @ModelAttribute("ft") FormTracking formTracking) {
        PengirimanDao pdao = new PengirimanDao();
        List<String> allListNoResi = new ArrayList<>();
        for (Pengiriman pengiriman : pdao.allListPengiriman()) {
            allListNoResi.add(pengiriman.getNoResi());
        }
        model.addAttribute("list", allListNoResi);
        return "insertTracking";
    }

    @RequestMapping("Tracking")
    public String Tracking(Model model, @ModelAttribute("ft") FormTracking formTracking) {
        PengirimanDao pdao = new PengirimanDao();
        List<String> allListNoResi = new ArrayList<>();
        for (Pengiriman pengiriman : pdao.allListPengiriman()) {
            allListNoResi.add(pengiriman.getNoResi());
        }
        model.addAttribute("list", allListNoResi);
        TrackingDao tdao = new TrackingDao();
        tdao.insertDatabaseTracking(formTracking.getNoResi(), formTracking.getStatusPengiriman());
        return "insertTracking";
    }

}
