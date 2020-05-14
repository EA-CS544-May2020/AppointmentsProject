package cs544.project.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer userid;
	@NotBlank(message = "First Name cannot be null or blank")
	private String firstName;
	@NotBlank(message = "Last Name cannot be null or blank")
	private String lastName;
	@Column(unique = true, length = 20)
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email cannot be null or blank")
	private String email;
	@NotBlank(message = "Gender cannot be null or blank")
	private String gender;
	@NotBlank(message = "UserName cannot be null or blank")
	private String username;
	@NotBlank(message = "Password cannot be null or blank")
	private String password;
	@Column(name = "enabled", columnDefinition = "boolean default true", nullable = false)
	@NotNull(message = "enabled cannot be null")
	private boolean enabled = true;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany
	@JoinTable(name = "User_Role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	private List<Role> roles = new ArrayList<Role>();

	public User() {
	}

	public User(String firstName, String lastName, String email, String gender, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserid() {
		return userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
