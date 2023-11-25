package com.example.demo.service;

import java.util.List;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Team;


public interface EmployeeService {
	
	Employee saveEmployee(Employee e);
	Employee getEmployee(Long id);
	List<Employee> getAllEmployee();
	
	Employee updateEmployee(Employee e);
	void deleteEmployee(Employee e);
	void deleteEmployeeById(Long id);
	

	List<Employee> findByNom(String nom);

	List<Employee> findByNomContains(String nom);

	List<Employee> findByNomSalaire(String nom, Double salaire);

	List<Employee> findByTeam(Team team);

	List<Employee> findByTeamIdTeam(Long id);

	List<Employee> trierEmployeesNomsSalaire();
	
	List<Employee> findByOrderByNomAsc();

}
