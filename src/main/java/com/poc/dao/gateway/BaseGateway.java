package com.poc.dao.gateway;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;

@Repository
public abstract class BaseGateway {
	@Autowired
	protected DSLContext jooq;
	
	public abstract void insert(DataTransferObject dto);
	public abstract void update(DataTransferObject dto);
	public abstract void delete(DataTransferObject dto);
	public abstract DataTransferObject fetch(DataTransferObject dto);
}
