package com.sanjeep.jms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanjeep.jms.model.Flight;
import com.sanjeep.jms.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
   
	@RequestMapping("findFlights")
	public <flightRepository> String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM/dd/yyyy")Date DepartureDate, ModelMap modelMap) {
         List<Flight> flights = flightRepository.findFlights(from, to, DepartureDate);
         modelMap.addAttribute("flights", flights);
		return "displayFlights";
}

	public FlightRepository getFlightRepository() {
		return flightRepository;
	}

	public void setFlightRepository(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
}