package com.example.vision.admission_start.model;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/rest")
@RestController

public class PatientController {
	
	@Value("${api.Url}")
	private String url;
	
	@Value("${rest.Url}")
	private String base_Url;

	@Autowired
	private RestTemplate restTemplate;
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PatientController.class);

	List<Patient> getEmployee = Arrays.asList(new Patient("1", "sanjeep", "Maharjan"),
			new Patient("2", "Peter", "tom"));

	@GetMapping("/patient")
	public List<Patient> getAllEmployee() {
		return getEmployee;
	}

	@RequestMapping("/physicians")
	@Consumes("application")
	public EmployeeList getPhysicians() {
		EmployeeList list = restTemplate.getForObject(base_Url, EmployeeList.class);
		return list;

	}

	@RequestMapping("/disease")
	@Produces("application/json")
	public DiseaseList  getDisease() {
		DiseaseList list =restTemplate.getForObject(url,DiseaseList.class);
		return list;
	}

	
	@RequestMapping("/patient/{Id}")
	public Patient employeeById(@PathVariable("Id") final String Id) {
		Patient emp = getEmployee.stream().filter(patient -> Id.equals(patient.getId())).findAny().orElse(null);
		return emp;
		
		
		
		
		
		
	}
}
