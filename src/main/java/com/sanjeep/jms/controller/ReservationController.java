package com.sanjeep.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanjeep.jms.dto.RequestReservation;
import com.sanjeep.jms.model.Flight;
import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.repos.FlightRepository;
import com.sanjeep.jms.service.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		  Flight flight = flightRepository.findById(flightId).get();
		  modelMap.addAttribute("flight", flight);
		 return "completeReservation";
	}
    
	 @RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	 public String completeReservation(RequestReservation request,ModelMap modelMap) {
		  Reservation reservation=reservationService.bookflight(request);
		  modelMap.addAttribute("msg", "RESERVATION IS SUCCESSFULLY DONE AND ID IS :"+reservation.getId());
		 return "reservationConfirmation";
		 
	 }

	public FlightRepository getFlightRepository() {
		return flightRepository;
	}


	public void setFlightRepository(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	
   
}
