package com.film.util;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("film");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;

	}
}
