package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTeam;
	private String nomTeam;
	private String descriptionTeam;

	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private List<Employee> employees;

	public Team() {
		super();
	}


	public Team(String nomTeam, String descriptionTeam, List<Employee> employees) {
		super();
		this.nomTeam = nomTeam;
		this.descriptionTeam = descriptionTeam;
		this.employees = employees;
	}


	public long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(long idTeam) {
		this.idTeam = idTeam;
	}

	public String getNomTeam() {
		return nomTeam;
	}

	public void setNomTeam(String nomTeam) {
		this.nomTeam = nomTeam;
	}

	public String getDescriptionTeam() {
		return descriptionTeam;
	}

	public void setDescriptionTeam(String descriptionTeam) {
		this.descriptionTeam = descriptionTeam;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
}
