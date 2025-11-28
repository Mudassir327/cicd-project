package com.bloodbank.api.repository;
import com.bloodbank.api.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {}