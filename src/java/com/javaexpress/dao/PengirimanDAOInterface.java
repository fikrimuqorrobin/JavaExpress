/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Pengiriman;
import java.util.List;

/**
 *
 * @author user
 */
public interface PengirimanDAOInterface {
    
    public void savePengiriman(Pengiriman pengiriman);
    
    public List<Pengiriman> findAllPengiriman();
    
    public Pengiriman findById(int id);
    
    public Pengiriman findByNoPengiriman(String nopengiriman);
}
