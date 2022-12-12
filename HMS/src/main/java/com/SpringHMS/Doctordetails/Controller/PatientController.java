package com.SpringHMS.Doctordetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringHMS.Doctordetails.model.Patient;
import com.SpringHMS.Doctordetails.service.PatientService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	//build create patient REST API
	@PostMapping()
	public ResponseEntity<Patient> saveRepository(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	//build get all doctor REST API
	@GetMapping
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
	}
	//build get patient by id REST API
	//http://localhost:8080/api/doctor/1
	@GetMapping("{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") long patientId){
		return new ResponseEntity<Patient>(patientService.getPatientById(patientId),HttpStatus.OK);
	}
	
	//build update patient REST API
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id,@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatient(patient,id),HttpStatus.OK);
	}
	//build delete patient REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id")long id){
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Patient deleted successfully!.",HttpStatus.OK);
	}
	
}


