package com.sarabadani.onlinecademy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 10:52 AM
 */
@javax.persistence.Entity
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer getVersion() {
        return version;
    }

    @Version
    private Integer version;
}
