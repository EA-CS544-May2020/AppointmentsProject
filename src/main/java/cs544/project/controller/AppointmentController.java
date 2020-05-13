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
import cs544.project.service.impl.AppointmentServiceImpl;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentServiceImpl appointmentService;
	
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
}
