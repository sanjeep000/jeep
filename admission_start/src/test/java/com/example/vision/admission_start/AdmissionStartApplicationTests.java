package com.example.vision.admission_start;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vision.admission_start.model.Patient;
import com.example.vision.admission_start.model.PatientController;

@SpringBootTest
class AdmissionStartApplicationTests {
	


	@Test
	void getAllPatients() {
		PatientController c=new PatientController();
		assertEquals(c.getAllEmployee().size(),2);
		
		
}
	@Test
	 void getPatientById() {
		List<Patient> list=new ArrayList<>();
		PatientController c=new PatientController();
		Patient p=new Patient("1","hero","lalo");
		assertEquals(c.employeeById(p.getId()),"sanjeep");
	    

	
		
	}

}
