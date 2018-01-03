package com.danielme.blog.hibernatefetching.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;


@Entity
@Table(name = "bird")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String band;

    // unidirectional
    @OneToOne     
    //@LazyToOne(LazyToOneOption.NO_PROXY)
    //@LazyGroup( "specie" )
    @JoinColumn(name = "specie_id")
    private Specie specie;

    // bidirectional
    @OneToOne
    //@OneToOne(optional=false, fetch=FetchType.LAZY)   
    //@LazyToOne(LazyToOneOption.NO_PROXY)
    //@LazyGroup( "cage" )
    @JoinColumn(name = "cage_id")
    private Cage cage;

    // bidirectional
    @ManyToOne
    //@ManyToOne(fetch=FetchType.LAZY)  
    //@LazyToOne(LazyToOneOption.NO_PROXY)
    //@LazyGroup( "breeder" )
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;
    
    //bidirectional
    @OneToMany(mappedBy = "bird")
    private List<Award> awards;
    
    //unidirectional
    @OneToMany
    @JoinColumn(name = "bird_id")
    private List<Note> notes;

    @ManyToMany
    @JoinTable(name = "bird_treatment", joinColumns = @JoinColumn(name = "bird_id"), 
    inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private Set<Treatment> treatments;
    
    @Basic(fetch=FetchType.LAZY)
    @Lob    
    private byte[] picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public Breeder getBreeder() {
        return breeder;
    }

    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}



    
}
