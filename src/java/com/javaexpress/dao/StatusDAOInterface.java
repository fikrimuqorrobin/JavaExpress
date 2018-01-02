/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexpress.dao;

import com.javaexpress.model.Status;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

public interface StatusDAOInterface {
    
    public void saveStatus(Status status);
    
    public List<Status> findAllStatus();
    
    public void updateStatus(int id);
}
