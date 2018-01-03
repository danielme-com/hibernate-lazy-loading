package com.danielme.blog.hibernatefetching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielme.blog.hibernatefetching.entities.Award;

public interface AwardRepository extends JpaRepository<Award, Long> {

}
