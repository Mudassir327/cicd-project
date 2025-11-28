package com.bloodbank.api.controller;
import com.bloodbank.api.model.Hospital;
import com.bloodbank.api.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/hospitals")
@CrossOrigin(origins = "http://localhost:3000")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;
    @PostMapping("/register")
    public Hospital registerHospital(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }
}