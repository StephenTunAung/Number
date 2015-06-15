package com.number.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao {

	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

}
