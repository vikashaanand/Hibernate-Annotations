package com.learn.hibernating;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "teachers_table")
public class Teacher {

	@Id
	private int t_id;
	private String t_name;

	private Qualification quali;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int t_id, String t_name) {
		this.t_id = t_id;
		this.t_name = t_name;
	}

	public Teacher(int t_id, String t_name, Qualification quali) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.quali = quali;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public Qualification getQuali() {
		return quali;
	}

	public void setQuali(Qualification quali) {
		this.quali = quali;
	}

	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", t_name=" + t_name + ", quali=" + quali + "]";
	}
	
}
