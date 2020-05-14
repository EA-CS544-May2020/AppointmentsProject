package cs544.project.service;

import java.util.List;

import cs544.project.domain.Appointment;
import cs544.project.domain.Reservation;

public interface AppointmentService {
	
	List<Appointment> getAll();
	Appointment getById(Integer id);
	Appointment create(Appointment appointment);
	Appointment update(Appointment appointment);
	void remove(Integer id);
	public List<Reservation> getReservations(Integer id);
	public Reservation getReservations(Integer id, Integer id2);
}
