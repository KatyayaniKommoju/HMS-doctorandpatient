package com.SpringHMS.Doctordetails.service;

import java.util.List;

import com.SpringHMS.Doctordetails.model.Doctor;

public interface DoctorService {
	Doctor saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctor();
	Doctor getDoctorById(long id);
	Doctor updateDoctor(Doctor doctor,long id);
	void deleteDoctor(long id);
}
