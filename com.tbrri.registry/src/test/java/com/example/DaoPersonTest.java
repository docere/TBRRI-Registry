package com.example;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.DaoPerson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.persist.PersistService;

public class DaoPersonTest {
	static Injector i;
	static PersistService service;
	Provider<EntityManager> emp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		i = Guice.createInjector(new MockTestingModule());
		service    = i.getInstance(PersistService.class);
		service.start();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeletePersons() {
		Person[] persons = i.getInstance(Person[].class);
		DaoPerson dao = i.getInstance(DaoPerson.class);
		

		for(Person p: persons)
		{
			long count = dao.count();
			dao.save(p);
			assertTrue (count + 1 == dao.count());
		}

		for(Person p: persons)
		{
			long count = dao.count();
			dao.delete(p);
			assertTrue (count - 1 == dao.count());
		}
		
		
		
	}
	

}
