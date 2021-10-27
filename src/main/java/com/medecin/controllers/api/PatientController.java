package com.medecin.controllers.api;

import com.medecin.model.Patient;
import com.medecin.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping({ "", "/all" })
    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping({ "", "/new" })
    public Patient addNewPatient(@RequestBody Patient patient ) {
        return patientRepository.save(patient);
    }

}
