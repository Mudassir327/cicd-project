package com.bloodbank.api.auth;

import com.bloodbank.api.model.Donor;
import com.bloodbank.api.model.RegistrationDTO;
import com.bloodbank.api.model.User;
import com.bloodbank.api.repository.DonorRepository;
import com.bloodbank.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO registration) {
        User user = new User();
        user.setUsername(registration.getUsername());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        userRepository.save(user);

        Donor donor = new Donor();
        donor.setName(registration.getName());
        donor.setBloodGroup(registration.getBloodGroup());
        donor.setContactNumber(registration.getContactNumber());
        donorRepository.save(donor);

        return user;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}