package com.yuripe.cms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuripe.cms.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  Optional<Car> findByPlate(String plate);
  
  List<Car> findAll();

  void deleteByPlate(String plate);
  }
