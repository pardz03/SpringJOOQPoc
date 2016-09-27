package com.poc.dao.gateway;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;
/**
 * 
 * @author joliveros
 *	all gateway must extends this parent class
 */
@Repository
public abstract class BaseGateway {
	@Autowired
	protected DSLContext jooq;
	
	public abstract void insert(DataTransferObject dto);
	public abstract void update(DataTransferObject dto);
	public abstract void delete(DataTransferObject dto);
	public abstract DataTransferObject fetch(DataTransferObject dto);
	
	
	/**
	 * method use for fetching data. List of Records is inserted automatically to Data Transfer Object
	 * @param results
	 * @return
	 */
	DataTransferObject setResults(List<Record> results){
		DataTransferObject returnDTO = new DataTransferObject();
		returnDTO.setResults(results);
		return returnDTO;
	}
}
