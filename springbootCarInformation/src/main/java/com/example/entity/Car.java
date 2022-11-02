package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car_Information_Storgae")
public class Car {

	@Id
	@Column(name = "CarId")
	private int cid;
	private String registration_number;
	private String engine_number;
	private String owner_name;
	private String colour;
	@Column(name = "CompanyName")
	private String manufarcturer;
	public String getManufarcturer() {
		return manufarcturer;
	}
	public void setManufarcturer(String manufarcturer) {
		this.manufarcturer = manufarcturer;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getRegistration_number() {
		return registration_number;
	}
	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}
	public String getEngine_number() {
		return engine_number;
	}
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", registration_number=" + registration_number + ", engine_number=" + engine_number
				+ ", owner_name=" + owner_name + ", colour=" + colour + ", manufarcturer=" +  manufarcturer + "]";
	}
}

