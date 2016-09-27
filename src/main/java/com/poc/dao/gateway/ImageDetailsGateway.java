package com.poc.dao.gateway;

import org.springframework.stereotype.Repository;
import static com.poc.db.tables.TblImagedetails.TBL_IMAGEDETAILS;

import com.poc.dto.DataTransferObject;
import com.poc.db.tables.records.TblImagedetailsRecord;

@Repository
public class ImageDetailsGateway extends BaseGateway{

	@Override
	public void insert(DataTransferObject dto) {
		// TODO Auto-generated method stub
		TblImagedetailsRecord record = new TblImagedetailsRecord();
		record.setComment(dto.getFullImageDetail().getComment());
		
		TblImagedetailsRecord recordResult = jooq.insertInto(TBL_IMAGEDETAILS).set(record).returning().fetchOne();
		dto.setImagedetailRecordResult(recordResult);
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
		return null;
	}

}
