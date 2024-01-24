package com.kosmos.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name; 
    private String last_name1;
    private String last_name2;
    private String specialty;
    
    public Doctor() {}

    public Doctor(String name, String last_name1, String last_name2, String specialty) {
        this.name = name;
        this.last_name1 = last_name1;
        this.last_name2 = last_name2;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name1() {
        return last_name1;
    }

    public void setLast_name1(String last_name1) {
        this.last_name1 = last_name1;
    }

    public String getLast_name2() {
        return last_name2;
    }

    public void setLast_name2(String last_name2) {
        this.last_name2 = last_name2;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
