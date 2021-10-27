package com.medecin.controllers.api;

import com.medecin.model.Doctor;
import com.medecin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping({ "" , "/all" })
    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @PostMapping({ "", "/all" })
    public void addNewDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }

}
