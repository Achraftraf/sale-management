package dao;

import java.util.List;

public interface DAO<T> {

	List<T> findAll();
	T find(Integer id);
	boolean insert(T obj);
	boolean update(T obj);
	boolean delete(T obj);
	
	
}
