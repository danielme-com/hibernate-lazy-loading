package com.danielme.blog.hibernatefetching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielme.blog.hibernatefetching.entities.Breeder;

public interface BreederRepository extends JpaRepository<Breeder, Long> {

}
