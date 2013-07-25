package com.example;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.DaoProject;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.persist.PersistService;

public class DaoProjectTest {
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
	public void testAddDeleteProject() {
		DaoProject dao = i.getInstance(DaoProject.class);
		
		Project[] projects = i.getInstance(Project[].class);
		
		long count = dao.count();
		for(Project p : projects)
		{
			dao.save(p);
			count++;
			assertTrue (count == dao.count());
		}
		
		count = dao.count();
		for(Project p : projects)
		{
			dao.delete(p);
			count--;
			assertTrue(count == dao.count());
		}
		
		
	}
	

}
