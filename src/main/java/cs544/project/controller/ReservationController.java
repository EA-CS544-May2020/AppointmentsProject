package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Reservation;
import cs544.project.domain.User;
import cs544.project.service.impl.ReservationServiceImpl;

@RestController
@RequestMapping(value="/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;

	
	@PostMapping
	public Reservation saveReservation(@RequestBody Reservation user) {
		return reservationService.create(user);
	}
	

	
	@PostMapping(value = "/update")
	public Reservation Reservation(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	}
	
	@PostMapping(value = "/delete/{id}")
	public void updateUser(@PathVariable Integer id) {
		reservationService.remove(id);
	}
}