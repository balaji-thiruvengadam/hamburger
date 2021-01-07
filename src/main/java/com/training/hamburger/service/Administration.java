package com.training.hamburger.service;

import java.io.IOException;

public interface Administration<T> {
	T list();
	void create(T entity) throws IOException;
	void update(T entity);
	void delete(T entity);
}
