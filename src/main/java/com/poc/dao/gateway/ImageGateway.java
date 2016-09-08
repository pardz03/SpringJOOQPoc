package com.poc.dao.gateway;

import static com.poc.db.tables.TblImage.TBL_IMAGE;

import java.util.List;

import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.stereotype.Component;

import com.poc.dto.DataTransferObject;

@Component
public class ImageGateway extends BaseGateway{

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
		SelectQuery<Record> selectQuery = jooq.selectQuery();
		selectQuery.addSelect(TBL_IMAGE.ID_IMAGE.as("id"));
		selectQuery.addSelect(TBL_IMAGE.NAME.as("name"));
		selectQuery.addSelect(TBL_IMAGE.PATH.as("path"));
		selectQuery.addFrom(TBL_IMAGE);
		List<Record> results = selectQuery.fetch();
		
		DataTransferObject returnDto = new DataTransferObject();
		returnDto.setResults(results);
		return returnDto;
	}

}
