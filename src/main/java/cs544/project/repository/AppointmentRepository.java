package cs544.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
