package com.danielme.blog.hibernatefetching.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="cage")
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    //bidirectional
    @OneToOne(mappedBy = "cage")
    //@LazyToOne(LazyToOneOption.NO_PROXY)
    //@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cage")    
    private Bird bird;    
   
    /*@OneToMany(mappedBy = "cage")
    private List<Bird> birds;
    public Bird getBird() {
        return birds != null && !birds.isEmpty() ? birds.get(0) : null;
    }

    public void setBird(Bird bird) {
        if (birds == null) {
        	birds = new ArrayList<>();
        }
        birds.set(0, bird);
    } */  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}  
    
    
    
}
