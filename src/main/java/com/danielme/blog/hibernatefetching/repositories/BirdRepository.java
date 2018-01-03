package com.danielme.blog.hibernatefetching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielme.blog.hibernatefetching.entities.Bird;

public interface BirdRepository extends JpaRepository<Bird, Long> {

}
