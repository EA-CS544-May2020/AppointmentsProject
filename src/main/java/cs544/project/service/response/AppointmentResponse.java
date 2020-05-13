package cs544.project.service.response;

import java.io.Serializable;
import java.util.Date;

public class AppointmentResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date date;
	private Date time;
	private String location;
	
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}
}
