package com.poc.dao;

import static com.poc.db.tables.TblImage.TBL_IMAGE;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc.domain.DomainFactory;
import com.poc.model.Image;

@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class ImageRepository extends BaseRepository{
	
	@Autowired
	DomainFactory<Image> imageFactory;
	
	public void select(){
		SelectQuery<Record> selectQuery = jooq.selectQuery();
		selectQuery.addSelect(TBL_IMAGE.ID_IMAGE.as("id"));
		selectQuery.addSelect(TBL_IMAGE.NAME.as("name"));
		selectQuery.addSelect(TBL_IMAGE.PATH.as("path"));
		selectQuery.addFrom(TBL_IMAGE);
		List<Record> results = selectQuery.fetch();

		List<Image> image = new ArrayList<Image>();
		
		for(Record r : results){
			Image i = imageFactory.make(r, Image.class);
			image.add(i);
		}

		System.out.println(results);
	}
}
