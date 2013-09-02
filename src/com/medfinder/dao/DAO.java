package com.medfinder.dao;

import java.util.List;

public interface DAO<T,PK> {
	public void insert(T entity);
	public void remove(T entity);
	public void removeById(PK id);
	public List<T> listAll();
	public T find(PK id);
	public void update(T entity);
	
	
	//teste
}