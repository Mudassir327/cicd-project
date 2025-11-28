package com.bloodbank.api.controller;
import com.bloodbank.api.model.BloodBag;
import com.bloodbank.api.repository.BloodBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class BloodBagController {
    @Autowired
    private BloodBagRepository bloodBagRepository;
    @PostMapping("/add")
    public BloodBag addBloodBag(@RequestBody BloodBag bloodBag) {
        return bloodBagRepository.save(bloodBag);
    }
    @GetMapping
    public List<BloodBag> getAllBloodBags() {
        return bloodBagRepository.findAll();
    }
}