package com.assignment.assignment.entity;

import com.assignment.assignment.entity.base.BaseEntity;
import com.assignment.assignment.entity.myenum.SizeStatus;

import java.time.LocalDateTime;

public class Size extends BaseEntity {

    private int id;
    private String name;
    private SizeStatus status;

    public Size() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = SizeStatus.ACTIVE;
    }

    public Size(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = SizeStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SizeStatus getStatus() {
        return status;
    }

    public void setStatus(SizeStatus status) {
        this.status = status;
    }
}
