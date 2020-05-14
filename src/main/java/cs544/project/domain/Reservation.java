package cs544.project.domain;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Integer id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime time;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Reservation() {}
			
	public Reservation(LocalDate date, LocalTime time, String status) {
		super();
		this.date = date;
		this.time = time;
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
