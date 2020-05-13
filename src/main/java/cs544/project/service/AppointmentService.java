package cs544.project.service;

import java.util.List;

import cs544.project.domain.Appointment;

public interface AppointmentService {
	
	List<Appointment> getAll();
	Appointment getById(Integer id);
	Appointment create(Appointment appointment);
	Appointment update(Appointment appointment);
	void remove(Integer id);
}
