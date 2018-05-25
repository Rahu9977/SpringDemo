package myprojectdemo.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class user  implements Serializable {

	
	@Id
	@GeneratedValue
	private int user_id;
	
	@Column(length=10)
	private String username;
	
	@Column(length=10)
	private String password;

	@Column(length=50)
	private String email;
	
	@Column(length=20)
	private String role;
	
	public enum flag{y,n}

	@Column(columnDefinition="ENUM ('y','n') default 'y'")
	@Enumerated(EnumType.STRING)
	private flag activation_flag;	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public flag getActivation_flag() {
		return activation_flag;
	}

	public void setActivation_flag(String activation_flag) {
		this.activation_flag = flag.valueOf(activation_flag);
	}

	
}
