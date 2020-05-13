package cs544.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.domain.Appointment;
import cs544.project.repository.AppointmentRepository;
import cs544.project.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements  AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Override
	public List<Appointment> getAll() {
		return appointmentRepo.findAll();
	}

	@Override
	public Appointment getById(Integer id) {
		Optional<Appointment> appointment = appointmentRepo.findById(id);
		if (appointment.isPresent()) {
			return appointment.get();
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
		Appointment oldAppointment = getById(appointment.getId());
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

}
