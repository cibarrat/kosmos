package com.kosmos.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Office {

    @Id
    private Long id;
    private int floor;

    public Office() {}

    public Office(Long id, int floor) {
        this.id = id;
        this.floor = floor;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    
}
