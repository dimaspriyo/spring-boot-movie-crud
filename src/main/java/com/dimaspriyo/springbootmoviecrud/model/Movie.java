package com.dimaspriyo.springbootmoviecrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	private int year;
	
	@NotNull
	private String genre;
	
	@NotNull
	private boolean remake;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isRemake() {
		return remake;
	}

	public void setRemake(boolean remake) {
		this.remake = remake;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movieeee [id=" + id + ", name=" + name + ", year=" + year + ", genre=" + genre + ", remake=" + remake
				+ "]";
	}
	
	
	
	
	
}
