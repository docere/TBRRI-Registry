package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.AbstractDao;
import com.example.Person;
import com.example.ProjectPersonAssociation;

public class DaoProjectPersonAssociation extends AbstractDao<ProjectPersonAssociation,Long>{

	public DaoProjectPersonAssociation()
	{
		this.clzz = ProjectPersonAssociation.class;
	}

	@Override
	public List<ProjectPersonAssociation> getAll()
	{
		EntityManager em = provideEM();
		Query q = em.createNamedQuery(ProjectPersonAssociation.FIND_ALL_PROJECT_PERSON_ASSOCIATIONS);
		
		return q.getResultList();
	}
	

}
