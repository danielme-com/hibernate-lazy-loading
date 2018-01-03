package com.danielme.blog.hibernatefetching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielme.blog.hibernatefetching.entities.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>{

}
