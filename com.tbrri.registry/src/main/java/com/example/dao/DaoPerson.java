package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.AbstractDao;
import com.example.Person;

public class DaoPerson extends AbstractDao<Person,Long>{


	public DaoPerson()
	{
		this.clzz = Person.class;
	}
	
	
	
	public List<Person> getAll()
	{
		EntityManager em = provideEM();
		Query q = em.createNamedQuery(Person.FIND_ALL_PERSONS);
		
		return q.getResultList();
	}



	


}
