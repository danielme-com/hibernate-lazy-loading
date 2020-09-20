package com.danielme.blog.hibernatefetching;

import com.danielme.blog.hibernatefetching.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchTest {

    private static final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("BirdsPersistence");
    private static EntityManager entityManager;

    private static final Logger log = LogManager.getLogger(FetchTest.class);

    @Before
    public void setup() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void shutdown() {
        entityManager.close();
    }

    @Test
    public void testBird() {
        log.info("--------> Bird");
        Bird bird = entityManager.find(Bird.class, 1L);;
        log.info("--------> Specie unidirectional OneToOne");
        bird.getSpecie().getName();
        log.info("--------> Picture - Lob Basic");
        bird.getPicture();
        log.info("--------> Awards bidirectional OneToMany");
        bird.getAwards().size();
        log.info("--------> Treatments Many to many");
        bird.getTreatments().size();
        log.info("--------> Breeder bidirectional ManyToOne");
        bird.getBreeder().getName();
        log.info("--------> Cage bidirectional OneToOne");
        bird.getCage().getName();
        log.info("--------> Notes unidirectional OneToMany");
        bird.getNotes().size();
    }

    @Test
    public void testAward() {
        log.info("--------> Award");
        Award award = entityManager.find(Award.class, 1L);
        log.info("--------> Bird bidirectional @ManyToOne");
        award.getBird().getBand();
    }

    @Test
    public void testBreeder() {
        log.info("--------> Breeder");
        Breeder breeder = entityManager.find(Breeder.class, 1L);
        log.info("--------> Birds bidirectional OneToMany");
        breeder.getBirds().size();
    }

    @Test
    public void testCage() {
        log.info("--------> Cage");
        Cage cage = entityManager.find(Cage.class, 1L);
        log.info("--------> Bird bidirectional OneToOne");
        cage.getBird().getBand();
    }

    @Test
    public void testTeatments() {
        entityManager.find(Treatment.class, 1L).getBirds().size();
    }

}
