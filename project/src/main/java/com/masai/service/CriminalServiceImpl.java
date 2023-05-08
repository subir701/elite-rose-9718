package com.masai.service;

import java.util.List;

import com.masai.DAO.CriminalDAO;
import com.masai.DAO.CriminalDAOImpl;
import com.masai.Entity.Criminal;
import com.masai.Exception.AlreadyExistException;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

public class CriminalServiceImpl implements CriminalService{

	@Override
	public void addCriminal(Criminal criminal) throws SomethingWrongAddingException, AlreadyExistException {
		CriminalDAO dao=new CriminalDAOImpl();
		dao.addCriminal(criminal);
		
	}

	@Override
	public List<Criminal> getCriminalList() throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CriminalDAO dao=new CriminalDAOImpl();
		return dao.getCriminalList();
	}

	@Override
	public void updateCriminal(Criminal criminal) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CriminalDAO dao=new CriminalDAOImpl();
		dao.updateCriminal(criminal);
		
	}

	@Override
	public void deleteCriminal(int id) throws SomethingWentWrongFetchingException, NoRecordFoundException {
		CriminalDAO dao=new CriminalDAOImpl();
		dao.deleteCriminal(id);
		
	}

}
