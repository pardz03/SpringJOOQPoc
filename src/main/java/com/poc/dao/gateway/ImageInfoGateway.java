package com.poc.dao.gateway;

import com.poc.dto.DataTransferObject;
import static com.poc.db.tables.TblImageinfo.TBL_IMAGEINFO;

import org.springframework.stereotype.Repository;

import com.poc.db.tables.records.TblImageinfoRecord;

@Repository
public class ImageInfoGateway extends BaseGateway{

	@Override
	public void insert(DataTransferObject dto) {
		// TODO Auto-generated method stub
		TblImageinfoRecord record = new TblImageinfoRecord();
		record.setIdDetails(dto.getFullImageDetail().getImageDetailsId());
		record.setIdImage(dto.getFullImageDetail().getImageId());
		jooq.insertInto(TBL_IMAGEINFO).set(record).execute();
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
