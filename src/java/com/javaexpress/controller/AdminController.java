package com.javaexpress.controller;

import com.javaexpress.DAO.KotaDAO;
import com.javaexpress.DAO.PengirimanDao;
import com.javaexpress.DAO.TarifDao;
import com.javaexpress.DAO.TrackingDao;
import com.javaexpress.Taglib.FormPengiriman;
import com.javaexpress.Taglib.FormTarif;
import com.javaexpress.Taglib.FormTracking;
import com.javaexpress.model.Kota;
import com.javaexpress.model.Pengiriman;
import com.javaexpress.model.Status;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class AdminController{

    Logger log = Logger.getLogger(AdminController.class.getName());
    private FileHandler fh;

    public void FileHandler() throws IOException {
        this.fh = new FileHandler("C:\\Users\\user\\Desktop\\Logging\\LoggingCourierService.log", true);
    }
    
    
    @RequestMapping()
    public String halamanIndex(Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/{username}")
    public String tampilAdmin(Model model){
        return "index";
    }
    
    @RequestMapping(value="test")
    public String test(Model model){     
        KotaDAO kd = new KotaDAO();
        try {
            FileHandler() ;
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("Melakukan Test pada kelas " + kd.ListKota() );
         
        } catch (IOException ex) {
            
        } catch (SecurityException ex) {
            
        }
        
        model.addAttribute("list",kd.ListKota());
        return "test";
    }
    
    @RequestMapping(value="insertTarif")
    public String insertDataTarif(Model model, @ModelAttribute("ft") FormTarif formTarif){
         KotaDAO kd = new KotaDAO();
         List<String> kotaAsal = new ArrayList<>();
         List<String> kotaTujuan = new ArrayList<>();
         for (Kota kota : kd.ListKota()) {
              kotaAsal.add(kota.getNamaKota());
         }
         
         for (Kota kota : kd.ListKota()) {
               kotaTujuan.add(kota.getNamaKota());
         }
         model.addAttribute("kotaAsal",kotaAsal);
         model.addAttribute("kotaTujuan",kotaTujuan);
         return "insertTarif";
    }
    
    @RequestMapping("insertTr")
    public String insertData(Model model, @ModelAttribute("ft") FormTarif formTarif){
         KotaDAO kd = new KotaDAO();
         List<String> kotaAsal = new ArrayList<>();
         List<String> kotaTujuan = new ArrayList<>();
         for (Kota kota : kd.ListKota()) {
              kotaAsal.add(kota.getNamaKota());
         }
         
         for (Kota kota : kd.ListKota()) {
               kotaTujuan.add(kota.getNamaKota());
         }
         model.addAttribute("kotaAsal",kotaAsal);
         model.addAttribute("kotaTujuan",kotaTujuan);
         
         KotaDAO kdao = new KotaDAO();
         Kota kodeKotaAsal = kdao.SelectKota(formTarif.getKotaAsal());
         Kota kodeKotaTujuan = kdao.SelectKota(formTarif.getKotaTujuan());
         
         TarifDao td = new TarifDao();
         td.InsertDataTarif(kodeKotaAsal, kodeKotaTujuan, formTarif.getTarifReguler(),
                 formTarif.getTarifKilat(), formTarif.getTarifOns(), formTarif.getTarifSds(), formTarif.getTarifHds());
         
         return "insertTarif";
    }
    
    @RequestMapping("SelectPengiriman")
    public String updatePengiriman(Model model){
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
            FileHandler() ;
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
    public String StatusPengiriman(Model model, @RequestParam("status") String Status, @RequestParam("ID") int ID){
        PengirimanDao pdao = new PengirimanDao();
        if(Status.equalsIgnoreCase("Tidak Aktif"))
        pdao.UpdateDatabasePengiriman(ID, new Status(2));
        if(Status.equalsIgnoreCase("Aktif"))
        pdao.UpdateDatabasePengiriman(ID, new Status(1));
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
        
        //Logging
     
       try {
            FileHandler() ;
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
    public String insertPengiriman(Model model, @ModelAttribute("fp") FormPengiriman formPengiriman){
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
         model.addAttribute("kotaAsal",kotaAsal);
         model.addAttribute("kotaTujuan",kotaTujuan);
         model.addAttribute("jenisLayanan",jenisLayanan);
    return "insertPengiriman";
    }    
    
    @RequestMapping("InsertP")
    public String insertP(Model model, @ModelAttribute("fp") FormPengiriman formPengiriman){
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
         model.addAttribute("kotaAsal",kotaAsal);
         model.addAttribute("kotaTujuan",kotaTujuan);
         
         
         model.addAttribute("jenisLayanan",jenisLayanan);
         
         KotaDAO kdao = new KotaDAO();
         Kota KotaPenerima = kdao.SelectKota(formPengiriman.getKotaPenerima());
         Kota KotaPengirim = kdao.SelectKota(formPengiriman.getKotaPengirim());
         
        String noResi = null;
        Timestamp x = new Timestamp(new Date().getTime());
        noResi = KotaPenerima.getKodeKota() +"A"+x.getTime()+"B"+ KotaPengirim.getKodeKota();
        PengirimanDao pdao = new PengirimanDao();
        TarifDao tdao = new TarifDao();
        int idTarif = tdao.idTarif(KotaPenerima,KotaPengirim);
        pdao.InsertDatabasePengiriman(formPengiriman.getAlamatPenerima(), formPengiriman.getAlamatPengirim(), formPengiriman.getAsuransi(), 
                formPengiriman.getBeratBarang(), formPengiriman.getHargaBarang(), formPengiriman.getJenisLayanan(), formPengiriman.getNamaPaket(), 
                formPengiriman.getNamaPenerima(), formPengiriman.getNamaPengirim(), noResi, formPengiriman.getTeleponPenerima(), formPengiriman.getTeleponPengirim(), 
                formPengiriman.getTipePaket(), KotaPenerima, KotaPengirim, idTarif);
        TrackingDao trackdao = new TrackingDao();
        trackdao.insertDatabaseTracking(noResi, "Dalam Masa Pengiriman");
        
    return "insertPengiriman";
    }
    
    @RequestMapping("insertTracking")
    public String insertTracking(Model model, @ModelAttribute("ft") FormTracking  formTracking){
        PengirimanDao pdao = new PengirimanDao();
        List<String> allListNoResi = new ArrayList<>();
        for (Pengiriman pengiriman : pdao.allListPengiriman()) {
            allListNoResi.add(pengiriman.getNoResi());
        }
        model.addAttribute("list", allListNoResi);
        return "insertTracking";
    }
    
    @RequestMapping("Tracking")
    public String Tracking(Model model, @ModelAttribute("ft") FormTracking  formTracking){
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
