package com.kosmos.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmos.hospital.model.Office;
import com.kosmos.hospital.repository.OfficeRepository;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOffice(Long id) {
        Optional<Office> office = officeRepository.findById(id);
        if (office.isPresent()) {
            return office.get();
        }
        throw new NullPointerException("Record does not exist");
    }

    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteAllBooks() {
        officeRepository.deleteAll();
    }

    public boolean deleteOffice(Long id) {
        Optional<Office> officeOptional = officeRepository.findById(id);
        if (officeOptional.isPresent()) {
            officeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
