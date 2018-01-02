/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Kota;
import java.util.List;

/**
 *
 * @author user
 */
public interface KotaDAOInterface {
    
    public void saveKota(Kota kota);
    
    public Kota findKotabyID(int kode_kota);
    
    public List<Kota> listKota();
        

}
