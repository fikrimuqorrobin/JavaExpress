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
public interface TrackingDAOInterface {

    public void updateTracking(Tracking tracking);

    public Tracking findByResiID(Integer id_tracking);

    public List<Tracking> tampilListNoResi();

    public Pengiriman findbyNoResi(String NoResi);

    public Status findStatusByNoResi(Integer id_status);

    public Tracking findTrackingByID(int id_pengiriman);
}
