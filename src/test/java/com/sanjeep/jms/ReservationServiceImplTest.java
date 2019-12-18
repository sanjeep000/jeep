package com.sanjeep.jms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanjeep.jms.model.Flight;
import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.repos.FlightRepository;
import com.sanjeep.jms.repos.PassengerRepository;
import com.sanjeep.jms.repos.ReservationRepository;
import com.sanjeep.jms.service.ReservationService;

public class ReservationServiceImplTest {

	 @Autowired
	private ReservationService service;
	public ReservationService getService() {
		return service;
	}
	public void setService(ReservationService service) {
		this.service = service;
	}
	
	@Mock
	ReservationRepository reservationRepo;
	FlightRepository flightRepo;
	PassengerRepository passengerRep;
	
	@Test
	void testForBookFlight() {
		Flight flight=new Flight();
		flight.setId(102L);
		 Reservation  reservation=new Reservation();
		 reservation.setFlight(flight);
		
		//when(reservationRepo.save(reservation)).thenReturn(Stream.of(t));
		fail("Not yet implemented");
	}

}
