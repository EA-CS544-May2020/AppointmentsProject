package cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Object> saveAppointment(@RequestBody Appointment appointment) {
		//check if the appointment exist
		Appointment app = appointmentService.findIdenticalAppointment(appointment.getDate(), 
				appointment.getTime(), appointment.getLocation().trim());
		if(app == null) {
			Appointment savedAppt = appointmentService.create(appointment);
			System.out.println("Blein" + app);
			return new ResponseEntity<Object>(savedAppt, HttpStatus.OK);
		} else {
			//response an exception
			return new ResponseEntity<Object>(new CustomException("Identical appointment already exist.", "500"), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/{id}")
	public Appointment getAppointment(@PathVariable Integer id) {
		return appointmentService.getById(id);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<Object> updateAppointment(@RequestBody Appointment appointment) {
		//check if the appointment exist
		Appointment app = appointmentService.findIdenticalAppointment(appointment.getDate(), 
				appointment.getTime(), appointment.getLocation().trim());
		if(app == null) {
			Appointment savedAppt = appointmentService.create(appointment);
			return new ResponseEntity<Object>(savedAppt, HttpStatus.OK);
		} else {
			//response an exception
			return new ResponseEntity<Object>(new CustomException("Identical appointment already exist.", "500"), HttpStatus.OK);
		}
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
		return appointmentService.getReservation(id,id2);
	}
}


