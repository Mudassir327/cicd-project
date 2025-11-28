package com.bloodbank.api.controller;

import com.bloodbank.api.model.Request;
import com.bloodbank.api.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:3000") // This line is crucial
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping("/create")
    public Request createRequest(@RequestBody Request request) {
        return requestRepository.save(request);
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}