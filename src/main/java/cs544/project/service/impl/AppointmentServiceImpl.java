package cs544.project.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.common.utils.DateTimeUtils;
import cs544.project.domain.Appointment;
import cs544.project.domain.Reservation;
import cs544.project.repository.AppointmentRepository;
import cs544.project.service.AppointmentService;
import cs544.project.service.mapper.AppointmentResponseMapper;
import cs544.project.service.response.AppointmentResponse;

@Service
@Transactional
public class AppointmentServiceImpl implements  AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	AppointmentResponseMapper appointmentResponseMapper; 
	
	@Override
	public List<AppointmentResponse> getAll() {
		return appointmentResponseMapper.mapCollection(appointmentRepo.findAll()); 
	}

	@Override
	public AppointmentResponse getById(Integer id) {
		Optional<Appointment> appointment = appointmentRepo.findById(id);
		if (appointment.isPresent()) {
			return appointmentResponseMapper.map(appointment.get());
		} else {
			return null;
		}
	}

	@Override
	public Appointment create(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment update(Appointment appointment) {
		Appointment oldAppointment = getwithId(appointment.getId());
		oldAppointment.setDate(appointment.getDate());
		oldAppointment.setTime(appointment.getTime());
		oldAppointment.setLocation(appointment.getLocation());
		oldAppointment.setUser(appointment.getUser());
		oldAppointment.setReservations(appointment.getReservations());
		return appointmentRepo.save(oldAppointment);	
	}

	@Override
	public void remove(Integer id) {
		appointmentRepo.deleteById(id);		
	}
	
	@Override
	public List<Reservation> getReservations(Integer id){
		Appointment appointment = getwithId(id);
		return appointment.getReservations();
	}
	
	@Override
<<<<<<< Updated upstream
	public Reservation getReservation(Integer id, Integer id2){
		Appointment appointment = getById(id);
=======
	public Reservation getReservations(Integer id, Integer id2){
		Appointment appointment = getwithId(id);
>>>>>>> Stashed changes
		List<Reservation> reservations = appointment.getReservations();
		Optional<Reservation> reservation= reservations.stream().filter(reserve -> reserve.getId()==id).findAny();
		if (reservation.isPresent()) {
			return reservation.get();
		} else {
			return null;
		}
	}

	@Override
<<<<<<< Updated upstream
	public Appointment findIdenticalAppointment(LocalDate date, LocalTime time, String location) {
		String dateStr = DateTimeUtils.getDateFormat(date, "yyyy-MM-dd");
		String timeStr = DateTimeUtils.getTimeFormat(time, "HH:mm:ss");
		Optional<Appointment> appointment =  appointmentRepo.findIdenticalAppointment(dateStr, timeStr, location);
		if(appointment.isPresent()) {
			return appointment.get();
		}
		else {
=======
	public Appointment getwithId(Integer id) {
		Optional<Appointment> appointment = appointmentRepo.findById(id);
		if (appointment.isPresent()) {
			return appointment.get();
		} else {
>>>>>>> Stashed changes
			return null;
		}
	}
}

