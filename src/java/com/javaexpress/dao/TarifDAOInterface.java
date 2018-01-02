/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Tarif;
import java.util.List;

/**
 *
 * @author user
 */
public interface TarifDAOInterface {
    
    public void saveTarif(Tarif tarif);
    
    public List<Tarif> findAllTarif();
    
    public Tarif findByIdTarif(int id);
    
    public void updateTarif(int id);
    
    
    
}
