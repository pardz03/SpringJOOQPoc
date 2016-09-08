package com.poc.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository<T> {
	@Autowired
	protected DSLContext jooq;

}
