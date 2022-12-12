package com.SpringHMS.Doctordetails.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringHMS.Doctordetails.ResourceNotFoundException.ResourceNotFoundException;
import com.SpringHMS.Doctordetails.daoRepository.DoctorRepository;
import com.SpringHMS.Doctordetails.model.Doctor;
import com.SpringHMS.Doctordetails.service.DoctorService;
@Service
public  class DoctorServiceImpl implements DoctorService{
	
	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@Override
	public List<Doctor> getAllDoctor() {
		
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(long id) {
		
		//Optional<Doctor> doctor=doctorRepository.findById(id);
		//if(doctor.isPresent()) {
		//	return doctor.get();
		//}else
		//{
		//	throw new ResourceNotFoundException("Doctor","Id",id);
		//}
		
		return doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor","Id",id));
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, long id) {
		// we need to check whether doctor with given id is existing in DB or not
		Doctor existingDoctor= doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor","Id",id));
		existingDoctor.setFirstName(doctor.getFirstName());
		existingDoctor.setLastName(doctor.getLastName());
		existingDoctor.setEmailId(doctor.getEmailId());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		existingDoctor.setPhoneNo(doctor.getPhoneNo());
		//save existing doctor to DB
		doctorRepository.save(existingDoctor);
		return null;
	}

	@Override
	public void deleteDoctor(long id) {
		
		doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor","Id",id));
		doctorRepository.deleteById(id);
	}


	
}

