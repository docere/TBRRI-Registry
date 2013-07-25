package com.example;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.DaoPerson;
import com.example.dao.DaoProject;
import com.example.dao.DaoProjectPersonAssociation;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.persist.PersistService;

public class DaoProjectPersonAssociationTest {
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
	public void testAddDeleteSingleProjectPersonAssociation()
	{
		DaoProjectPersonAssociation dao = i.getInstance(DaoProjectPersonAssociation.class);
		DaoPerson daoPerson = i.getInstance(DaoPerson.class);
		DaoProject daoProject = i.getInstance(DaoProject.class);
		
		
		Project[] projects = i.getInstance(Project[].class);
		Person[] persons = i.getInstance(Person[].class);
		
		Project project = projects[0];
		Person person = persons[0];
		
		daoProject.save(project);
		daoPerson.save(person);
		
		ProjectPersonAssociation pa = new ProjectPersonAssociation();
		
		pa.setPerson(person);
		pa.setProject(project);
		
		long count = dao.count();
		
		dao.save(pa);
		count++;
		assertTrue(count == dao.count());
		
		dao.delete(pa);
		count--;
		assertTrue(count==dao.count());
		
		//need to refind project and person objects because they became orphaned from delete transaction above
		project = daoProject.findByID(project.getId()); 
		daoProject.delete(project);
		assertTrue(daoProject.count()==0);

		person = daoPerson.findByID(person.getId());
		daoPerson.delete(person);
		assertTrue(daoPerson.count() ==0);
	}
	
	public void testAddDeleteProjectPersonAssociations() {
		DaoProjectPersonAssociation dao = i.getInstance(DaoProjectPersonAssociation.class);
		
		Project[] projects = i.getInstance(Project[].class);
		Person[] persons = i.getInstance(Person[].class);

		
		Project[] projectSubSet = new Project[2];
		projectSubSet[0] = projects[0];
		projectSubSet[1] = projects[1];
		
		
		
		for(Project p : projectSubSet)
		{
			long count = dao.count();

			for(Person person: persons)
			{
				ProjectPersonAssociation pa = new ProjectPersonAssociation();
				pa.setProject(p);
				pa.setPerson(person);
				
				dao.save(pa);
				count++;
				assertTrue (count == dao.count());
				
			}
		}
		
		
	}
	

}
