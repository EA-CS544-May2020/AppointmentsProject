package cs544.project.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.domain.Reservation;
import cs544.project.repository.ReservationRepository;
import cs544.project.service.IReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Override
	public List<Reservation> getAll() {
		
		return reservationRepo.findAll();
	}

	@Override
	public Reservation getById(Integer id) {
		Optional<Reservation> reservation =  reservationRepo.findById(id);
		if(reservation.isPresent()) {
			//return modelMapper.map(reservation, OrderDTO.class);
			return reservation.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Reservation create(Reservation reservation) {
		return reservationRepo.save(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) {
		//1 get by Id return reservation In db
		//2 merge reservation to reservation in db
		//3 save reservation In db
		return reservation;
	}

	@Override
	public void remove(Integer id) {
		reservationRepo.deleteById(id);
		
	}

	@Override
	public List<Reservation> getReservationsByStatus(String status) {
		return reservationRepo.findByStatus(status);
	}

	@Override
	public Reservation findByDateAndTime(Date date, Date time) {
		Optional<Reservation> reservation =  reservationRepo.findByDateAndTime(date, time);
		if(reservation.isPresent()) {
			return reservation.get();
		}
		else {
			return null;
		}
	}

}
