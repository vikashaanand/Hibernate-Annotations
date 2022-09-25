package com.learn.hibernating;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "teacher_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sn;
	
	@Column(length = 50)
	private String city;
	
	@Column(name = "METRO_CITY", length = 1)
	private boolean isMetro;
	
	@Transient
	private int count;
	
	@Temporal(TemporalType.DATE)
	private Date moveInDate;
	
	@Lob
	private byte[] image;

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isMetro() {
		return isMetro;
	}

	public void setMetro(boolean isMetro) {
		this.isMetro = isMetro;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [sn=" + sn + ", city=" + city + ", isMetro=" + isMetro + ", count=" + count + ", moveInDate="
				+ moveInDate + ", image=" + Arrays.toString(image) + "]";
	}
	
}
