package com.rogowiczdawid.gamestore.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
	private Date reg_date;
	
	/////Constructors/////
	public User(){}
	public User(String user, String pass, String email){
		this.setName(user);
		this.setEmail(email);
		this.setPassword(pass);
	}
	
	//////Getters/////
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Date getReg_date() {
		return reg_date;
	}
	
	/////Setters//////
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}	
}
