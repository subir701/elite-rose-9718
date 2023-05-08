package com.masai.service;

import java.util.List;

import com.masai.DAO.CrimeDAO;
import com.masai.DAO.CrimeDAOImpl;
import com.masai.Entity.Crime;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

public class CrimeServiceImpl implements CrimeService{

	@Override
	public void addCrime(Crime crime) throws SomethingWrongAddingException {
		CrimeDAO dao=new CrimeDAOImpl();
		dao.addCrime(crime);
		
	}

	@Override
	public List<Crime> getCrimeList() throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CrimeDAO dao=new CrimeDAOImpl();
		return dao.getCrimeList();
	}

	@Override
	public void updateCrime(Crime crime) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CrimeDAO dao=new CrimeDAOImpl();
		dao.updateCrime(crime);
		
	}

	@Override
	public void deleteCrime(int id) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		
		CrimeDAO dao=new CrimeDAOImpl();
		dao.deleteCrime(id);
	}

	@Override
	public void assignCrime(int crime_id, int criminal_id)
			throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CrimeDAO dao=new CrimeDAOImpl();
		dao.assignCrime(crime_id, criminal_id);
		
	}

	@Override
	public void removeCriminal(int crime_id, int criminal_id)
			throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CrimeDAO dao=new CrimeDAOImpl();
		dao.removeCriminal(crime_id, criminal_id);
		
	}

}
