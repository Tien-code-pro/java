package com.assignment.assignment.model;

import com.assignment.assignment.entity.Size;

import java.util.List;

public interface SizeModel {
    Size save(Size size);

    List<Size> findAll();

    Size findById(int id);

    Size update(int id, Size size);

    boolean delete(int id);
}
