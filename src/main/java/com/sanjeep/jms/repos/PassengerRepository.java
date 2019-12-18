package com.sanjeep.jms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeep.jms.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
