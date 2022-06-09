package com.example.baithi.controller;

import com.example.baithi.entity.Employees;
import com.example.baithi.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {

    @Autowired
     EmployeesService employeesService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employees>> getList() {
        return ResponseEntity.ok(employeesService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employees> create(@RequestBody Employees employees) {
        return ResponseEntity.ok(employeesService.save(employees));
    }
}
