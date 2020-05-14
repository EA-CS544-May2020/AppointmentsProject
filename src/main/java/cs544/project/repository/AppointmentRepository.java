package cs544.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cs544.project.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	@Query(value = "SELECT * FROM Appointment a WHERE a.date = :date AND a.time = :time AND "
			+ " a.location = :location LIMIT 1", nativeQuery = true)
	public Optional<Appointment> findIdenticalAppointment(@Param("date") String date, 
			@Param("time") String time , @Param("location") String location);
}
