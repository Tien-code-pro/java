package com.assignment.assignment.entity;

import com.assignment.assignment.entity.base.BaseEntity;
import com.assignment.assignment.entity.myenum.ColorStatus;

import java.time.LocalDateTime;

public class Color extends BaseEntity {
    private int id;
    private String name;
    private ColorStatus status;

    public Color() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ColorStatus.ACTIVE;
    }

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ColorStatus.ACTIVE;
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

    public ColorStatus getStatus() {
        return status;
    }

    public void setStatus(ColorStatus status) {
        this.status = status;
    }
}
