package com.SpringHMS.Doctordetails.service;

import java.util.List;


import com.SpringHMS.Doctordetails.model.Patient;

public interface PatientService {
	Patient savePatient(Patient patient);
	List<Patient> getAllPatient();
	Patient getPatientById(long id);
	Patient updatePatient(Patient patient,long id);
	void deletePatient(long id);
}
