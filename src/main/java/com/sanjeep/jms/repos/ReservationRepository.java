package com.sanjeep.jms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeep.jms.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
