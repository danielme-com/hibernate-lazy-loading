package com.danielme.blog.hibernatefetching;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.danielme.blog.hibernatefetching.ApplicationContext;
import com.danielme.blog.hibernatefetching.entities.Award;
import com.danielme.blog.hibernatefetching.entities.Bird;
import com.danielme.blog.hibernatefetching.entities.Breeder;
import com.danielme.blog.hibernatefetching.entities.Cage;
import com.danielme.blog.hibernatefetching.repositories.AwardRepository;
import com.danielme.blog.hibernatefetching.repositories.BirdRepository;
import com.danielme.blog.hibernatefetching.repositories.BreederRepository;
import com.danielme.blog.hibernatefetching.repositories.CageRepository;
import com.danielme.blog.hibernatefetching.repositories.TreatmentRepository;

/**
 * Some test cases.
 * 
 * @author danielme.com
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
@Transactional
public class FetchTest {

	private static final Logger log = Logger.getLogger(FetchTest.class);

	@Autowired
	private BirdRepository birdRepository;
	@Autowired
	private AwardRepository awardRepository;
	@Autowired
	private BreederRepository breederRepository;
	@Autowired
	private CageRepository cageRepository;
	@Autowired
	private TreatmentRepository treatmentRepository;

	@Test
	public void testBird() {
		log.info("--------> Bird");
		Bird bird = birdRepository.findById(1L).get();
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
		Award award = awardRepository.findById(1L).get();
		log.info("--------> Bird bidirectional @ManyToOne");
		award.getBird().getBand();
	}

	@Test
	public void testBreeder() {
		log.info("--------> Breeder");
		Breeder breeder = breederRepository.findById(1L).get();
		log.info("--------> Birds bidirectional OneToMany");
		breeder.getBirds().size();
	}

	@Test
	public void testCage() {
		log.info("--------> Cage");
		Cage cage = cageRepository.findById(1l).get();
		log.info("--------> Bird bidirectional OneToOne");
		cage.getBird().getBand();
	}

	@Test
	public void testTeatments() {
		treatmentRepository.findById(1l).get().getBirds().size();
	}

}
