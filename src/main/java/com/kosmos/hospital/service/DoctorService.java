package com.kosmos.hospital.service;

import com.kosmos.hospital.model.Doctor;
import com.kosmos.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        }
        throw new NullPointerException("Record does not exist");
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteAllBooks() {
        doctorRepository.deleteAll();
    }

    public boolean deleteDoctor(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
