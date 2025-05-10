package com.fiap.sprint1_java2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.sprint1_java2025.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, String> {

}
