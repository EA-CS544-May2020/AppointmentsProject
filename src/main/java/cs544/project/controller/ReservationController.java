package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Reservation;
import cs544.project.exceptions.CustomException;
import cs544.project.service.impl.ReservationServiceImpl;

@RestController
@RequestMapping(value="/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;

	@GetMapping("/world")
	public String helloWorld() {
		return "hello";
	}

	@PostMapping
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		return reservationService.create(reservation);
	}
	
	@GetMapping
	public List<Reservation> getList() {
		return reservationService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable Integer id) {
		Reservation resv = reservationService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(resv);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Object> Reservation(@RequestBody Reservation reservation) {
		
		//1. check reservation is overlapped
		Reservation reserDb = reservationService.findByDateAndTime(reservation.getDate(), reservation.getTime(), "ACCEPTED", reservation.getUser().getUserid());
		if(reserDb == null) {
		
			Reservation updatedResv =  reservationService.updateStatus(reservation);
		
			return new ResponseEntity<Object>(updatedResv, HttpStatus.OK);
		}
		else {
			//response an exception
			return new ResponseEntity<Object>(new CustomException("The reservation is overlapped", "500"), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/delete/{id}")
	public void deleteReservation(@PathVariable Integer id) {
		reservationService.remove(id);
	}
}