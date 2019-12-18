package com.sanjeep.jms.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanjeep.jms.dto.RequestReservation;
import com.sanjeep.jms.model.Flight;
import com.sanjeep.jms.model.Passenger;
import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.repos.FlightRepository;
import com.sanjeep.jms.repos.PassengerRepository;
import com.sanjeep.jms.repos.ReservationRepository;
import com.sanjeep.jms.util.EmailUtil;
import com.sanjeep.jms.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	 

	private  String ITIENARY_DIR = "/Users/jyoti/Downloads/reservation/reservation";

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	@Transactional
	public Reservation bookflight(RequestReservation request) {
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savePassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath =ITIENARY_DIR + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItenary(savedReservation, filePath);
		emailUtil.sendItenary(passenger.getEmail(), filePath);

		// TODO Auto-generated method stub
		return savedReservation;
	}

}
