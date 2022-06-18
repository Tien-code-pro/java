package com.example.street_spring.service;

import com.example.street_spring.entity.Street;
import com.example.street_spring.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    public List<Street> findAll() {
        return streetRepository.findAll();
    }
    public Optional<Street> findById(String id) {
        return streetRepository.findById(id);
    }
    public Street save(Street street) {
        return streetRepository.save(street);
    }

}
