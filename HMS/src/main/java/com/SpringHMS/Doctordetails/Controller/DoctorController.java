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


import com.SpringHMS.Doctordetails.model.Doctor;
import com.SpringHMS.Doctordetails.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	//build create doctor REST API
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> saveRepository(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	//build get all doctor REST API
	@GetMapping("/all")
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctor();
	}
	//build get doctor by id REST API
	//http://localhost:8080/api/doctor/1
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long doctorId){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorId),HttpStatus.OK);
	}
	
	//build update doctor REST API
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id,@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor,id),HttpStatus.OK);
	}
	//build delete doctor REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id")long id){
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor deleted successfully!.",HttpStatus.OK);
	}
	
}


