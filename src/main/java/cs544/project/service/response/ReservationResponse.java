package cs544.project.service.response;

import java.io.Serializable;
import java.util.Date;

public class ReservationResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Date time;
	
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
