package com.masai.DAO;

import java.util.List;

import com.masai.Entity.Criminal;
import com.masai.Exception.AlreadyExistException;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CriminalDAOImpl implements CriminalDAO{

	@Override
	public void addCriminal(Criminal criminal) throws SomethingWrongAddingException , AlreadyExistException{
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Query query=em.createQuery("SELECT COUNT(c) FROM Criminal c WHERE crimial_name= :name");
			query.setParameter("name", criminal.getName());
			if((Long)query.getSingleResult()>0) {
				throw new AlreadyExistException("Criminal is already existed in the data");
			}
			
			EntityTransaction et= em.getTransaction();
			et.begin();
			em.persist(criminal);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWrongAddingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Criminal> getCriminalList() throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		List<Criminal> list=null;
		try {
			em=DButils.getConnection();
			Query query=em.createQuery("SELECT c FROM Criminal c");
			list=query.getResultList();
			if(list.size() ==0) {
				throw new NoRecordFoundException("No criminal found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongFetchingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
		return list;
	}

	@Override
	public void updateCriminal(Criminal criminal) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Criminal crimianlFromDB=em.find(Criminal.class, criminal.getCriminalId());
			if(crimianlFromDB==null)
				throw new NoRecordFoundException("No criminal found with given name "+ criminal.getName());
			EntityTransaction et= em.getTransaction();
			et.begin();
			crimianlFromDB.setArrested_ps_area(criminal.getArrested_ps_area());;
			crimianlFromDB.setDob(criminal.getDob());
			crimianlFromDB.setFirst_arrest_date(criminal.getFirst_arrest_date());
			crimianlFromDB.setGender(criminal.getGender());
			crimianlFromDB.setIdentifying_marks(criminal.getIdentifying_marks());
			crimianlFromDB.setName(criminal.getName());
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongFetchingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteCriminal(int id) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		EntityManager em=null;
		try {
			em=DButils.getConnection();
			Criminal criminal=em.find(Criminal.class, id);
			if(criminal == null)
				throw new NoRecordFoundException("No criminal found of given id "+ id);
			EntityTransaction et=em.getTransaction();
			et.begin();
			criminal.setIsDeleted(1);
			et.commit();
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongFetchingException("Unable to procced , try again later");
		}finally {
			em.close();
		}
	}

}
