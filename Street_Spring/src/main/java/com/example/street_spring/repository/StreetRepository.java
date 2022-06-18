package com.example.street_spring.repository;

import com.example.street_spring.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, String>, JpaSpecificationExecutor<Street> {
}
