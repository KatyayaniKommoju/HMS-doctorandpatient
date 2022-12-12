package com.SpringHMS.Doctordetails.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringHMS.Doctordetails.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
