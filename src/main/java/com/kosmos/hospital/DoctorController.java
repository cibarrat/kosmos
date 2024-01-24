package com.kosmos.hospital;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.hospital.model.Doctor;
import com.kosmos.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public String getDoctor(@RequestParam(value = "id") Long id) {
        try {
            return new JSONObject(doctorService.getDoctor(id)).toString();
        }
        catch (NullPointerException ex) {
            return new JSONObject(ex).toString(0);
        }
    }

    @PostMapping
    public String addDoctor(@RequestBody Doctor doctor) {
        return new JSONObject(doctorService.saveDoctor(doctor)).toString();
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        if (doctorService.deleteDoctor(id)) {
            return "Successfully deleted record";
        }
        return "Record not found";
    }

}
