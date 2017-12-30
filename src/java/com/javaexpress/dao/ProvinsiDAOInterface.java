/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.*;
import java.util.List;

/**
 *
 * @author user
 */
public interface ProvinsiDAOInterface {
    
    public void saveProvinsi(Provinsi provinsi);
    
    public List<Provinsi> findAllProvinsi();
    
    public Provinsi findById(int kode_provinsi);
}
