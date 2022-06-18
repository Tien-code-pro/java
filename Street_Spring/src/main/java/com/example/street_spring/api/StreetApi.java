package com.example.street_spring.api;

import com.example.street_spring.entity.Street;
import com.example.street_spring.entity.Street;
import com.example.street_spring.repository.StreetRepository;
import com.example.street_spring.service.StreetService;
import com.example.street_spring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetApi {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Street>> getList(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }
}
