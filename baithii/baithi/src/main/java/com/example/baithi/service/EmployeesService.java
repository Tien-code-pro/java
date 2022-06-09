package com.example.baithi.service;

import com.example.baithi.entity.Employees;
import com.example.baithi.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;
    public Iterable<Employees> findAll() {
        return employeesRepository.findAll();
    }

    public Employees save(Employees employee) {
        return employeesRepository.save(employee);
    }


}
