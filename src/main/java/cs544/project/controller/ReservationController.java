package cs544.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Reservation;
import cs544.project.service.impl.ReservationServiceImpl;
import cs544.project.service.response.ReservationResponse;

@RestController
@RequestMapping(value="/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;

	@RequestMapping(value="", method = RequestMethod.POST)
	public ReservationResponse addReservation(@RequestBody Reservation reservation) {
		
		return null;
	}
}