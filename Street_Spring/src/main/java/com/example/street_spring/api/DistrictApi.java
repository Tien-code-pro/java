package com.example.street_spring.api;

import com.example.street_spring.entity.District;
import com.example.street_spring.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/districts")
public class DistrictApi {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<District>> getList(){
        return ResponseEntity.ok(districtService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody District district){
        return ResponseEntity.ok(districtService.save(district));
    }
}
