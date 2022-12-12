package com.SpringHMS.Doctordetails.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringHMS.Doctordetails.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{

}
