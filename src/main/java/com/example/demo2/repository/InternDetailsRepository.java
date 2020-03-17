package com.example.demo2.repository;

import com.example.demo2.resources.entity.InternsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternDetailsRepository extends JpaRepository<InternsDetails,Long> {
}
