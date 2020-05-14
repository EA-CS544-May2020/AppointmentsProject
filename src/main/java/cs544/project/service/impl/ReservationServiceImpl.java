package cs544.project.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.common.utils.DateTimeUtils;
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
	public Reservation updateStatus(Reservation reservation) {
		Reservation reservDb = getById(reservation.getId());
		reservDb.setStatus(reservation.getStatus());
		return reservationRepo.saveAndFlush(reservDb);
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
	public Reservation findByDateAndTime(LocalDate date, LocalTime time, String status, Integer userId) {
		String dateStr = DateTimeUtils.getDateFormat(date, "yyyy-MM-dd");
		String timeStr = DateTimeUtils.getTimeFormat(time, "HH:mm:ss");
		Optional<Reservation> reservation =  reservationRepo.findByDateAndTime(dateStr, timeStr, status, userId);
		if(reservation.isPresent()) {
			return reservation.get();
		}
		else {
			return null;
		}
	}

}
