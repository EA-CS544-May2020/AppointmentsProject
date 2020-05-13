package cs544.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
