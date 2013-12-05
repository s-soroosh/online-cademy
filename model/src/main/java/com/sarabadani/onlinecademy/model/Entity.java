package com.sarabadani.onlinecademy.model;

import javax.persistence.*;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 10:52 AM
 */
@MappedSuperclass
public abstract class Entity {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer getVersion() {
        return version;
    }

    @Version
    private Integer version;
}
