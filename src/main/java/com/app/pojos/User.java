package com.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users_spring")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="MARKS")
	private int marks;
	
	public User() {
		System.out.println("User called here");
	}

	public User(String name, String city, int marks) {
		super();
		this.name = name;
		this.city = city;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + marks + "]";
	}

	
	
	

}
