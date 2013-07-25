package com.example;

import javax.persistence.EntityManager;

import com.example.dao.IDao;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public abstract class AbstractDao<T, K> implements IDao<T, K> {
	// this needs to be initialized on child classes
	protected Class<T> clzz;

	@Inject
	private Provider<EntityManager> emp;

	@Override
	@Transactional
	public void save(T object) {
		EntityManager em = emp.get();
		em.persist(object);
	}

	@Override
	@Transactional
	public void delete(T object) {
		EntityManager em = emp.get();
		em.remove(object);
	}


	@Override
	public T findByID(K id) {
		EntityManager em = emp.get();
		return (T) em.find(clzz, id);
	}

	@Override
	public long count() {
		return getAll().size();
	}

	protected EntityManager provideEM() {
		return emp.get();
	}

	public static void main(String[] args) {
	}

}
