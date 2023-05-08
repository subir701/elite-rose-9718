package com.masai.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Criminal {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int criminalId;
	@Column(name="crimial_name", nullable = false)
	private String name;
	@Column(name="crimial_dob", nullable = false)
	private LocalDate dob;
	@Column(name="crimial_gender", nullable = false)
	private char gender;
	private int isDeleted;
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	private String identifying_marks;
	private LocalDate first_arrest_date;
	private String arrested_ps_area;
	@ManyToMany(cascade =  CascadeType.ALL)
	@JoinTable(name = "Crime_Criminal", joinColumns = {@JoinColumn(name = "criminalId")}, inverseJoinColumns = {@JoinColumn(name ="crimeId")})
	private Set<Crime> list;
	public Set<Crime> getList() {
		return list;
	}
	public void setList(Set<Crime> list) {
		this.list = list;
	}
	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Criminal(String name, LocalDate dob, char gender, String identifying_marks, LocalDate first_arrest_date,
			String arrested_ps_area) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_marks = identifying_marks;
		this.first_arrest_date = first_arrest_date;
		this.arrested_ps_area = arrested_ps_area;
	}
	public int getCriminalId() {
		return criminalId;
	}
	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getIdentifying_marks() {
		return identifying_marks;
	}
	public void setIdentifying_marks(String identifying_marks) {
		this.identifying_marks = identifying_marks;
	}
	public LocalDate getFirst_arrest_date() {
		return first_arrest_date;
	}
	public void setFirst_arrest_date(LocalDate first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}
	public String getArrested_ps_area() {
		return arrested_ps_area;
	}
	public void setArrested_ps_area(String arrested_ps_area) {
		this.arrested_ps_area = arrested_ps_area;
	}
	@Override
	public String toString() {
		return "criminalId=" + criminalId + " | name=" + name + " | dob=" + dob + " | gender=" + gender
				+ " | identifying_marks=" + identifying_marks + " | first_arrest_date=" + first_arrest_date
				+ " | arrested_ps_area=" + arrested_ps_area +" | isDeleted="+ isDeleted;
	}
	
}
