package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.domain.Appointment;
import cs544.project.domain.Reservation;
import cs544.project.service.impl.AppointmentServiceImpl;
import cs544.project.service.impl.ReservationServiceImpl;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentServiceImpl appointmentService;
	
	

	@PostMapping
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return appointmentService.create(appointment);
	}

	

	@PostMapping(value = "/update")
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return appointmentService.update(appointment);
	}
	
	
	
	@GetMapping(value = "/{id}/reservations")
	public List<Reservation> getReservations(@PathVariable Integer id) {
		return appointmentService.getReservations(id);
	}
	
	@GetMapping(value = "/{id}/reservations/{id2}")
	public Reservation getReservation(@PathVariable Integer id, @PathVariable Integer id2) {
		return appointmentService.getReservations(id,id2);
	}
}
