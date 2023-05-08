package com.masai.DAO;

import java.util.List;

import com.masai.Entity.Criminal;
import com.masai.Exception.AlreadyExistException;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

public interface CriminalDAO {
	void addCriminal(Criminal criminal)throws SomethingWrongAddingException,AlreadyExistException;
	List<Criminal> getCriminalList()throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void updateCriminal(Criminal criminal)throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void deleteCriminal(int id)throws SomethingWentWrongFetchingException, NoRecordFoundException;
	
}
