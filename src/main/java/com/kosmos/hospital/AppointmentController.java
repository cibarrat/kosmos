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

import com.kosmos.hospital.model.Appointment;
import com.kosmos.hospital.service.AppointmentService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String getAppointment(@RequestParam(value = "id") Long id) {
        try {
            return new JSONObject(appointmentService.getAppointment(id)).toString();
        }
        catch (NullPointerException ex) {
            return new JSONObject(ex).toString(0);
        }
    }

    @PostMapping
    public String addAppointment(@RequestBody Appointment appointment) {
        try {
            return new JSONObject(appointmentService.saveAppointment(appointment)).toString();
        } 
        catch (EntityExistsException ex) {
            return ex.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        if (appointmentService.deleteAppointment(id)) {
            return "Successfully deleted record";
        }
        return "Record not found";
    }

}
