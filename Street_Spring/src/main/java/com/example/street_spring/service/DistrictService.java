package com.example.street_spring.service;

import com.example.street_spring.entity.District;
import com.example.street_spring.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public Iterable<District> findAll(){
        return districtRepository.findAll();
    }

    public Optional<District> findById(String id){
        return districtRepository.findById(id);
    }
    public District save(District district){
        return districtRepository.save(district);
    }
}
