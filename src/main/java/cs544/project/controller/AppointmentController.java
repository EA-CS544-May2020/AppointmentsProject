package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Appointment;
import cs544.project.domain.Reservation;
import cs544.project.exceptions.CustomException;
import cs544.project.service.impl.AppointmentServiceImpl;
import cs544.project.service.impl.ReservationServiceImpl;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentServiceImpl appointmentService;
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Appointment> getAppointments() {
		return appointmentService.getAll();
	}

	@PostMapping
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return appointmentService.create(appointment);
	}

	@GetMapping(value = "/{id}")
	public Appointment getAppointment(@PathVariable Integer id) {
		return appointmentService.getById(id);
	}

	@PostMapping(value = "/update")
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return appointmentService.update(appointment);
	}
	
	@DeleteMapping(value = "/{id}")
	public void removeAppointment(@PathVariable Integer id) {
		appointmentService.remove(id);
	}
	
	@GetMapping(value = "/{id}/reservations")
	public List<Reservation> getReservations(@PathVariable Integer id) {
		return appointmentService.getReservations(id);
	}
	
	@GetMapping(value = "/{id}/reservations/{id2}")
	public Reservation getReservation(@PathVariable Integer id, @PathVariable Integer id2) {
		return appointmentService.getReservations(id,id2);
	}
	
	@PostMapping(value = "/{id}/reservations")
	public ResponseEntity<Object> saveReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
		//1. check reservation is overlapped
		Reservation reserDb = reservationService.findByDateAndTime(reservation.getDate(), reservation.getTime(), "ACCEPTED", reservation.getUser().getUserid());
		if(reserDb == null) {
		//2. get appointment by Id
		Appointment appointmentDb = appointmentService.getById(id);
		
		//3. add the reservation to list
		appointmentDb.setReservation(reservation);
		
		//3. update appointment to save the reservation
		Appointment updateApp = appointmentService.update(appointmentDb);
		return new ResponseEntity<Object>(updateApp, HttpStatus.OK);
		}
		else {
			//response an exception
			return new ResponseEntity<Object>(new CustomException("The reservation is overlapped", "500"), HttpStatus.OK);
		}
		
	}
}


