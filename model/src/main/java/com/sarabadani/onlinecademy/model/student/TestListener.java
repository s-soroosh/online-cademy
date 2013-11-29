package com.sarabadani.onlinecademy.model.student;

import javax.persistence.PrePersist;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 2:15 PM
 */
public class TestListener {
    @PrePersist
    public void beforeSave(Object o){
        System.out.println(o.toString());
    }
}
