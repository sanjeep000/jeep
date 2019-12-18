package com.sanjeep.jms.service;

import com.sanjeep.jms.dto.RequestReservation;
import com.sanjeep.jms.model.Reservation;

public interface ReservationService {
	
	public Reservation bookflight(RequestReservation request);

}
