package cs544.project.service.response;

import java.io.Serializable;

public class UserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String firstName;
	private String lastName;	
	private String email;
	private String gender;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
