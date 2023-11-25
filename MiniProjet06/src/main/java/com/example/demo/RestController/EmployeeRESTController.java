package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeRESTController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(path="all" , method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value ="/addempl", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@RequestMapping(value="/updateempl",method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/delempl/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
	}

	@RequestMapping(value = "/employeeteam/{idTeam}", method = RequestMethod.GET)
	public List<Employee> getEmployeesByTeamId(@PathVariable("idTeam") Long idTeam) {
		return employeeService.findByTeamIdTeam(idTeam);
	}
	
	@RequestMapping(value="/employeebynom/{nomEmployee}",method = RequestMethod.GET)
	public List<Employee> findByNomContains(@PathVariable("nomEmployee") String nomEmployee) {
	return employeeService.findByNomContains(nomEmployee);
	}
}
