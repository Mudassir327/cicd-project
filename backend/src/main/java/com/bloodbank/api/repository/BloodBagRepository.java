package com.bloodbank.api.repository;
import com.bloodbank.api.model.BloodBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BloodBagRepository extends JpaRepository<BloodBag, Long> {}