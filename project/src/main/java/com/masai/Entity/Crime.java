package com.masai.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Crime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int crimeId;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String ps_area;
	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private ArrayList<String> name;
	@Column(nullable = false)
	private Set<Criminal> list;
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crime(String type, String description, String ps_area, LocalDate date, ArrayList<String> name,
			Set<Criminal> list) {
		super();
		this.type = type;
		this.description = description;
		this.ps_area = ps_area;
		this.date = date;
		this.name = name;
		this.list = list;
	}
	public int getCrimeId() {
		return crimeId;
	}
	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPs_area() {
		return ps_area;
	}
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ArrayList<String> getName() {
		return name;
	}
	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	public Set<Criminal> getList() {
		return list;
	}
	public void setList(Set<Criminal> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", type=" + type + ", description=" + description + ", ps_area=" + ps_area
				+ ", date=" + date + ", name=" + name + ", list=" + list + "]";
	}
	
}
