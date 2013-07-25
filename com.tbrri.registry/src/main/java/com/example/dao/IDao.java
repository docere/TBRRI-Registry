package com.example.dao;

import java.util.List;


public interface IDao<T,K> {

	public void save(T object);
	public void delete(T object);
	public T findByID(K id);
	public long count();
	public List<T> getAll();
}
