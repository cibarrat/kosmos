package com.kosmos.hospital.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int office; 
    private Long doctor;
    private Date time;
    private String patient;

    public Appointment() {}

    public Appointment(int office, Long doctor, Date time, String patient) {
        this.office = office;
        this.doctor = doctor;
        this.time = time;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
        this.doctor = doctor;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
