package com.kosmos.hospital.service;

import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class HospitalService {
    private final JpaRepository<Object, Long> repository;

    public HospitalService(JpaRepository<Object, Long> repository) {
        this.repository = repository;
    }

    public JSONObject get(Long id) {
        Optional<Object> optional = repository.findById(id);
        if (optional.isPresent()) {
            return new JSONObject(optional.get());
        }
        return new JSONObject("{\"error\":\"ID not found\"}");
    }

    public JSONObject save(Object object) {
        return new JSONObject(repository.save(object));
    }

    public boolean delete(Long id) {
        Optional<Object> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
