package com.danielme.blog.hibernatefetching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielme.blog.hibernatefetching.entities.Cage;

public interface CageRepository extends JpaRepository<Cage, Long>{

}
