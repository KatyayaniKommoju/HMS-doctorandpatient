package com.SpringHMS.Doctordetails.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringHMS.Doctordetails.ResourceNotFoundException.ResourceNotFoundException;

import com.SpringHMS.Doctordetails.daoRepository.PatientRepository;

import com.SpringHMS.Doctordetails.model.Patient;
import com.SpringHMS.Doctordetails.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {

private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepository.findAll();
	}
	@Override
	public Patient getPatientById(long id) {
		
		//Optional<Doctor> doctor=doctorRepository.findById(id);
		//if(doctor.isPresent()) {
		//	return doctor.get();
		//}else
		//{
		//	throw new ResourceNotFoundException("Doctor","Id",id);
		//}
		
		return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","Id",id));
	}
	@Override
	public Patient updatePatient(Patient patient, long id) {
		// we need to check whether doctor with given id is existing in DB or not
		Patient existingPatient= patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient","Id",id));
		existingPatient.setFirstName(patient.getFirstName());
		existingPatient.setLastName(patient.getLastName());
		existingPatient.setEmailId(patient.getEmailId());
		existingPatient.setDob(patient.getDob());
		existingPatient.setPhoneNo(patient.getPhoneNo());
		existingPatient.setGender(patient.getGender());
		existingPatient.setCity(patient.getCity());
		//save existing doctor to DB
		patientRepository.save(existingPatient);
		return null;
	}

	public void deletePatient(long id) {
		
		patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient","Id",id));
		patientRepository.deleteById(id);
	}
}
