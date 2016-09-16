package com.poc.dao.gateway;

import static com.poc.db.tables.TblImage.TBL_IMAGE;

import java.util.List;

import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.stereotype.Component;

import com.poc.db.tables.records.TblImageRecord;
import com.poc.dto.DataTransferObject;

@Component
public class ImageGateway extends BaseGateway{

	@Override
	public void insert(DataTransferObject dto) {
		// TODO Auto-generated method stub
		TblImageRecord record = new TblImageRecord();
		record.setName(dto.getImage().getName());
		record.setPath(dto.getImage().getPath());
		
		jooq.insertInto(TBL_IMAGE).set(record).returning().fetchOne();
	}

	@Override
	public void update(DataTransferObject dto) {
		// TODO Auto-generated method stub
		jooq.update(TBL_IMAGE)
		.set(TBL_IMAGE.NAME,dto.getImage().getName())
		.set(TBL_IMAGE.PATH,dto.getImage().getPath())
		.where(TBL_IMAGE.ID_IMAGE.in(Integer.parseInt(dto.getImage().getId())))
		.execute();
	}

	@Override
	public void delete(DataTransferObject dto) {
		// TODO Auto-generated method stub
		jooq.delete(TBL_IMAGE).where(TBL_IMAGE.ID_IMAGE.eq(Integer.parseInt(dto.getImage().getId())))
		.execute();
	}

	@Override
	public DataTransferObject fetch(DataTransferObject dto) {
		// TODO Auto-generated method stub
		SelectQuery<Record> selectQuery = jooq.selectQuery();
		selectQuery.addSelect(TBL_IMAGE.ID_IMAGE.as("id"));
		selectQuery.addSelect(TBL_IMAGE.NAME.as("name"));
		selectQuery.addSelect(TBL_IMAGE.PATH.as("path"));
		selectQuery.addFrom(TBL_IMAGE);
		List<Record> results = selectQuery.fetch();	
		return super.setResults(results);
	}

}
