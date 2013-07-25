package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.AbstractDao;
import com.example.Person;
import com.example.Project;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class DaoProject extends AbstractDao<Project,Long> {
	public DaoProject()
	{
		this.clzz = Project.class;
	}



	@Override
	public List<Project> getAll() {
		EntityManager em = provideEM();
		Query q = em.createNamedQuery(Project.FIND_ALL_PROJECTS);
		return q.getResultList();
	}
	
	

}
