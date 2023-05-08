package com.masai.service;

import java.util.List;

import com.masai.Entity.Crime;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongFetchingException;
import com.masai.Exception.SomethingWrongAddingException;

public interface CrimeService {
	void addCrime(Crime crime) throws SomethingWrongAddingException;
	List<Crime> getCrimeList()throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void updateCrime(Crime crime)throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void deleteCrime(int id)throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void assignCrime(int crime_id,int criminal_id)throws SomethingWentWrongFetchingException, NoRecordFoundException;
	void removeCriminal(int crime_id,int criminal_id )throws SomethingWentWrongFetchingException, NoRecordFoundException;
}
