package com.javaexpress.controller;

import com.javaexpress.DAO.KotaDAO;
import com.javaexpress.DAO.PengirimanDao;
import com.javaexpress.DAO.TarifDao;
import com.javaexpress.DAO.TrackingDao;
import com.javaexpress.DTO.TarifDto;
import com.javaexpress.DTO.TrackingPengirimanDto;
import com.javaexpress.model.Tracking;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webservice")//
public class RestControllerTarif {
    
    @RequestMapping("allListTarif")
    public Map<String,Object> ListTarif(){
    Map<String,Object> mdto = new HashMap<>();
    List<TarifDto> ldto = new ArrayList<>();
    TarifDao tdao = new TarifDao();
    ldto = tdao.SelectDatabaseTarifDto();
    mdto.put("Tarif", ldto);
    mdto.put("Asuransi", (int)(new TarifDto().asuransi*100)+"%");
    return mdto;
    }
    
    @RequestMapping("trackingPengiriman")
    public List<TrackingPengirimanDto> trackingPengiriman(@RequestParam("noResi") String noResi){
    List<TrackingPengirimanDto> ltpdto = new ArrayList<>();
    TrackingDao tdao = new TrackingDao();
    TrackingPengirimanDto trackDTo = new TrackingPengirimanDto();
    trackDTo.setStatusPengiriman(tdao.selectTracking(noResi).getStatusPengiriman());
    ltpdto.add(trackDTo);
    return ltpdto;
    }
    
    @RequestMapping("totalCost")
    public Map<String,Object> cost(@RequestParam("asal") String kotaAsal, @RequestParam("tujuan") String kotaTujuan ,
                                                @RequestParam("berat") double beratBarang,  @RequestParam("harga") double hargaBarang ,
                                                @RequestParam("asuransi") char asuransi, @RequestParam("layanan") String jenisLayanan){
        Map<String,Object> map = new HashMap<>();
        try{
        String noResi = null;
        Timestamp x = new Timestamp(new Date().getTime());
        KotaDAO kdao = new KotaDAO();
        noResi = kdao.idKotaFromDatabase(kotaAsal) +"A"+x.getTime()+"B"+ kdao.idKotaFromDatabase(kotaTujuan);
        PengirimanDao pdao = new PengirimanDao();
        double hargaTotal = pdao.getTarif(kotaAsal,kotaTujuan,beratBarang, hargaBarang, asuransi, jenisLayanan).doubleValue();
        DecimalFormat df = new DecimalFormat("###,###.00");
        String total = df.format(hargaTotal);
        map.put("Nomor Resi Pengiriman", noResi);
        map.put("Total Harga", "Rp."+total);
        }
        catch(NoResultException ex){
        map.put("Error Encountered", "Form yang anda berikan tidak dapat ditemukan pada database kami");
        }
        return map;
    }
}
