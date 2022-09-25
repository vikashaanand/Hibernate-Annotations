package com.learn.hibernating;

import javax.persistence.Embeddable;

@Embeddable
public class Qualification {
	
	private String degree;
	private String institute;
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualification(String degree, String institute) {
		super();
		this.degree = degree;
		this.institute = institute;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	@Override
	public String toString() {
		return "Qualification [degree=" + degree + ", institute=" + institute + "]";
	}
}
