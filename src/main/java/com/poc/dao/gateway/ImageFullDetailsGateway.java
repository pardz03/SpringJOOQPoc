package com.poc.dao.gateway;

import static com.poc.db.tables.TblImage.TBL_IMAGE;
import static com.poc.db.tables.TblImagedetails.TBL_IMAGEDETAILS;
import static com.poc.db.tables.TblImageinfo.TBL_IMAGEINFO;

import java.util.List;

import org.jooq.Record;
import org.springframework.stereotype.Component;

import com.poc.dto.DataTransferObject;

@Component
public class ImageFullDetailsGateway extends BaseGateway{

	@Override
	public void insert(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataTransferObject fetch(DataTransferObject dto) {
		// TODO Auto-generated method stub		
		List<Record> results = jooq.select(TBL_IMAGE.NAME.as("name"))
		.select(TBL_IMAGE.PATH.as("path"))
		.select(TBL_IMAGEDETAILS.COMMENT.as("comment"))
		.from(TBL_IMAGE)
		.leftOuterJoin(TBL_IMAGEINFO).on(TBL_IMAGE.ID_IMAGE.eq(TBL_IMAGEINFO.ID_IMAGE))
		.leftOuterJoin(TBL_IMAGEDETAILS).on(TBL_IMAGEDETAILS.ID_DETAILS.eq(TBL_IMAGEINFO.ID_DETAILS))
		.fetch();
		return super.setResults(results);
	}

}
