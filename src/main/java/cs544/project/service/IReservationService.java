package cs544.project.service;

import java.util.List;

import cs544.project.domain.Reservation;

public interface IReservationService {
	List<Reservation> getAll();

	Reservation getById(Integer id);

	Reservation create(Reservation reservation);

	Reservation update(Reservation reservation);

	void remove(Integer id);
}
