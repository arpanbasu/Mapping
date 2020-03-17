package com.example.demo2.repository;

import com.example.demo2.resources.entity.Interns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Interns, Long> {
}
