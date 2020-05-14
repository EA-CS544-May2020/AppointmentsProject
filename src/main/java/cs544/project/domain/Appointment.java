package cs544.project.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Integer id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime time;
	
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "appointment_id")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Appointment() {}
			
	public Appointment(LocalDate date, LocalTime time, String location) {
		this.date = date;
		this.time = time;
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
}
