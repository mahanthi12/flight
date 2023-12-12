package com.capgemini.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.example.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
