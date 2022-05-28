package com.assignment.assignment.model;

import com.assignment.assignment.entity.Color;

import java.util.List;

public interface ColorModel {
    Color save(Color color);

    List<Color> findAll();

    Color findById(int id);

    Color update(int id,Color color);

    boolean delete(int id);
}
