package com.poc.dao.domainfactory;

import org.jooq.Record;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainFactory<T> {
	
	@Autowired
	protected ModelMapper modelMapper;
	
	/**
	 * Makes the requested real objects from the jooq's Record Type via ModelMapper
	 * it is used particularly on data retrieval.
	 * 
	 * @param JooQ Record Type
	 * @return the target Domain Class<T>
	 */
	public T make(Record record,Class<T> account) {
		T resultAccount = modelMapper.map(record,account);
		return resultAccount;
	}
}
