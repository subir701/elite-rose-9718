package com.masai.DAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masai.Entity.Crime;
import com.masai.Entity.Criminal;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CrimeDAOImpl implements CrimeDAO{

	@Override
	public void addCrime(Crime crime) throws SomethingWrongAddingException {
		EntityManager em=null;
		try {
			em = DButils.getConnection();
			 Query query= em.createQuery("SELECT count(c) FROM Crime c WHERE description = : description");
			 query.setParameter("description", crime.getDescription());
			 if((Long)query.getSingleResult()>0) {
				 throw new SomethingWrongAddingException("Unable to add crime is already registered");
			 }
			 EntityTransaction et=em.getTransaction();
			 et.begin();
			 em.persist(crime);
			 et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWrongAddingException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Crime> getCrimeList() throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em= null;
		List<Crime> crimeList= null;
		try {
			em=DButils.getConnection();
			Query query = em.createQuery("FROM Crime c");
			crimeList = (List<Crime>)query.getResultList();
			if(crimeList.size() == 0) {
				throw new NoRecordFoundException("No Crime Found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongFetchingException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		return crimeList;
	}

	@Override
	public void updateCrime(Crime crime) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em= null;
		try {
			em=DButils.getConnection();
			Crime crimeFromDB = em.find(Crime.class, crime.getCrimeId());
			if(crimeFromDB == null) {
				throw new NoRecordFoundException("No crime is found with given id "+ crime.getCrimeId());
			}
			EntityTransaction et=em.getTransaction();
			et.begin();
			crimeFromDB.setDate(crime.getDate());
			crimeFromDB.setDescription(crime.getDescription());
			crimeFromDB.setPs_area(crime.getPs_area());
			crimeFromDB.setType(crime.getType());
			crimeFromDB.setName(crime.getName());
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongFetchingException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteCrime(int id) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Crime crime=em.find(Crime.class, id);
			if(crime == null) {
				throw new NoRecordFoundException("No crime is found with given id "+ crime.getCrimeId());
			}
			EntityTransaction et=em.getTransaction();
			et.begin();
			crime.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongFetchingException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void assignCrime(int crime_id, int criminal_id)
			throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Crime crime=em.find(Crime.class, crime_id);
			Criminal criminal=em.find(Criminal.class, criminal_id);
			if(crime==null)
				throw new NoRecordFoundException("No crime is found of given id "+crime_id);
			if(criminal == null)
				throw new NoRecordFoundException("No criminal is found of given id "+criminal_id);
			EntityTransaction et=em.getTransaction();
			et.begin();
			Set<Criminal> set=new HashSet<>();
			set.add(criminal);
			crime.setList(set);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongFetchingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void removeCriminal(int crime_id, int criminal_id)
			throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Crime crime=em.find(Crime.class, crime_id);
			Criminal criminal=em.find(Criminal.class, criminal_id);
			if(crime==null)
				throw new NoRecordFoundException("No crime is found of given id "+crime_id);
			if(criminal == null)
				throw new NoRecordFoundException("No criminal is found of given id "+criminal_id);
			EntityTransaction et=em.getTransaction();
			et.begin();
			Set<Criminal> set=crime.getList();
			set.remove(criminal);
			crime.setList(set);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongFetchingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
		
	}

}
