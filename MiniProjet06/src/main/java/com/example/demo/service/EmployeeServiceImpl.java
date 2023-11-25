package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Team;
import com.example.demo.Repos.EmployeeRepository;
import com.example.demo.Repos.ImageRepository;
import com.example.demo.entities.Image;




@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee e) {
		//Long oldEmplImageId = this.getEmployee(e.getId()).getImage().getIdImage();
		//Long newEmplImageId = e.getImages().getIdImage();
		Employee emplUpdated = employeeRepository.save(e);
		//if (oldEmplImageId != newEmplImageId) //si l'image a été modifiée
		//ImageRepository.deleteById(oldEmplImageId);
		return emplUpdated;
	}

	@Override
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee p = getEmployee(id);
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByNom(String nom) {
		return employeeRepository.findByNom(nom);
	}

	@Override
	public List<Employee> findByNomContains(String nom) {
		return employeeRepository.findByNomContains(nom);
	}

	@Override
	public List<Employee> findByNomSalaire(String nom, Double salaire) {
		return employeeRepository.findByNomSalaire(nom, salaire);
	}

	@Override
	public List<Employee> findByTeam(Team team) {
		return employeeRepository.findByTeam(team);
	}

	@Override
	public List<Employee> findByTeamIdTeam(Long id) {
		return employeeRepository.findByTeamIdTeam(id);
	}

	@Override
	public List<Employee> trierEmployeesNomsSalaire() {
		return employeeRepository.trierEmployeesNomsSalaire();
	}

	@Override
	public List<Employee> findByOrderByNomAsc() {
		return employeeRepository.findByOrderByNomAsc();
	}
	
	
}
