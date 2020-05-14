package cs544.project.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import cs544.project.domain.Reservation;

public interface IReservationService {
	List<Reservation> getAll();

	Reservation getById(Integer id);

	Reservation create(Reservation reservation);

	Reservation updateStatus(Reservation reservation);

	void remove(Integer id);
	
	List<Reservation> getReservationsByStatus(String status);
	
	Reservation findByDateAndTime(LocalDate date, LocalTime time, String status, Integer userId);
}
