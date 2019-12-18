package com.sanjeep.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeep.jms.dto.ReservationupdateReservation;
import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;

	 @RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).get();
		
	}
	 @PostMapping("/reservation")
	 public Reservation updateReservation(@RequestBody ReservationupdateReservation request) {
		 Reservation reservation=reservationRepository.findById(request.getId()).get();
		 reservation.setNumberOfBags(request.getNumberOfBags());
		 reservation.setCheckedIn(request.getCheckedIn());
		 return reservationRepository.save(reservation);
		
		 
	 }
}

