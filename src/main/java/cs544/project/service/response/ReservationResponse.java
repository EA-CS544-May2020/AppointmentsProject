package cs544.project.service.response;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern="yyyy-MM-dd")
	public Date date;
	
	@Temporal(TemporalType.TIME)
	//@JsonFormat(pattern="HH:mm:ss")
	public Date time;
	
	
	public ReservationResponse() {}
	public ReservationResponse(Date date, Date time) {
		super();
		this.date = date;
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
