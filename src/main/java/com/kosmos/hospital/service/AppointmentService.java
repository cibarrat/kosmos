package com.kosmos.hospital.service;

import com.kosmos.hospital.model.Appointment;
import com.kosmos.hospital.repository.AppointmentRepository;

import jakarta.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return appointment.get();
        }
        throw new NullPointerException("Record does not exist");
    }

    public Appointment saveAppointment(Appointment appointment) {
        int office = appointment.getOffice();
        Date date = appointment.getTime();
        if (findByDateAndOffice(date, office).isEmpty()) {
            return appointmentRepository.save(appointment);
        } 
        throw new EntityExistsException("Office is occupied at specified hour");
    }

    public void deleteAllBooks() {
        appointmentRepository.deleteAll();
    }

    public boolean deleteAppointment(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Appointment> findByDate(Date date) {
        Appointment appointment = new Appointment();
        appointment.setTime(date);
        Example<Appointment> example = Example.of(appointment);
        return appointmentRepository.findAll(example);
    }

    public List<Appointment> findByDateAndOffice(Date date, int office) {
        Appointment appointment = new Appointment();
        appointment.setTime(date);
        appointment.setOffice(office);
        Example<Appointment> example = Example.of(appointment);
        return appointmentRepository.findAll(example);
    }
}
