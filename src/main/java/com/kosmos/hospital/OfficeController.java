package com.kosmos.hospital;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.hospital.model.Office;
import com.kosmos.hospital.service.OfficeService;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public String getOffice(@RequestParam(value = "id") Long id) {
        try {
            return new JSONObject(officeService.getOffice(id)).toString();
        }
        catch (NullPointerException ex) {
            return new JSONObject(ex).toString(0);
        }
    }

    @PostMapping
    public String addOffice(@RequestBody Office office) {
        return new JSONObject(officeService.saveOffice(office)).toString();
    }

    @DeleteMapping("/{id}")
    public String deleteOffice(@PathVariable Long id) {
        if (officeService.deleteOffice(id)) {
            return "Successfully deleted record";
        }
        return "Record not found";
    }

}
