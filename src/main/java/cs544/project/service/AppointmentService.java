package cs544.project.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import cs544.project.domain.Appointment;
import cs544.project.domain.Reservation;
import cs544.project.service.response.AppointmentResponse;

public interface AppointmentService {
	
	List<AppointmentResponse> getAll();
	AppointmentResponse getById(Integer id);
	Appointment getwithId(Integer id);
	Appointment create(Appointment appointment);
	Appointment update(Appointment appointment);
	void remove(Integer id);
	public List<Reservation> getReservations(Integer id);
	public Reservation getReservation(Integer id, Integer id2);
	public Appointment findIdenticalAppointment(LocalDate date, LocalTime time, String location);
}
