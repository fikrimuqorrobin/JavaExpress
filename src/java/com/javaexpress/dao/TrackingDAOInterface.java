/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Tracking;
import java.util.List;

/**
 *
 * @author user
 */
public interface TrackingDAOInterface {
    
    public List<Tracking> findAllTracking();
}
