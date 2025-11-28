package com.bloodbank.api.repository;
import com.bloodbank.api.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DonorRepository extends JpaRepository<Donor, Long> {}