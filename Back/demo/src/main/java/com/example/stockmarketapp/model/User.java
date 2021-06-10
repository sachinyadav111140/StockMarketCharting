package com.example.stockmarketapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Integer id;



	@Column(unique = true)
	private String username;

	private String password;
	private Role userType =  Role.USER;;
	
	@Column(unique = true)
	private String email;
	
	private String mobileNumber;
	
	@Column(columnDefinition = "bit default 0")
	private boolean confirmed = false;
	
	
	
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



	public String getUserType() {
		return userType.name();
	}



	public void setUserType(Role userType) {
		this.userType = userType;
	}

	public void setUserType() {
		this.userType = Role.USER;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public boolean isConfirmed() {
		return confirmed;
	}



	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	
	public User(Integer id, String username, String password, Role userType, String email, String mobileNumber,
			boolean confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}

	public User( String username, String password, String email, String mobileNumber) {
		super();
//		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = Role.USER;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmed = false;
	}
	
//	public User(Integer id, String username, String password, Role userType, String email, boolean confirmed) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.userType = userType;
//		this.email = email;
//		this.mobileNumber = "";
//		this.confirmed = confirmed;
//	}

	

	
	public User() {
		super();
		this.confirmed=false;
	}



	public User(String username, String password, Role userType, String email, String mobileNumber,
			boolean confirmed) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}
	
}
