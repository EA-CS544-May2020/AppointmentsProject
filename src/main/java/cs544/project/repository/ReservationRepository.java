package cs544.project.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs544.project.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	//public List<Reservation> findByStatus(String status);
	@Query(value = "SELECT * FROM Reservation r WHERE r.status = :status", nativeQuery = true)
	public List<Reservation> findByStatus(@Param("status") String status);
	
	@Query(value = "SELECT * FROM Reservation r WHERE r.date = :date AND r.time = :time", nativeQuery = true)
	public Optional<Reservation> findByDateAndTime(@Param("date") Date date, @Param("time") Date time);
}
