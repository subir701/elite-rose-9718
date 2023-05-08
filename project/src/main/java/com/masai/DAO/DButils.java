package com.masai.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DButils {
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("project");
	}
	static EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
