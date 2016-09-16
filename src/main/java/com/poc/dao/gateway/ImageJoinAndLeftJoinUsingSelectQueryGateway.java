package com.poc.dao.gateway;

import static com.poc.db.tables.TblImage.TBL_IMAGE;
import static com.poc.db.tables.TblImagedetails.TBL_IMAGEDETAILS;
import static com.poc.db.tables.TblImageinfo.TBL_IMAGEINFO;

import java.util.List;

import org.jooq.JoinType;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.stereotype.Component;

import com.poc.dto.DataTransferObject;

@Component
public class ImageJoinAndLeftJoinUsingSelectQueryGateway extends BaseGateway{

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

	/**
	 * this method has a new style of selecting via jooq.selectQuery() method
	 * 
	 * select * from tbl_image ti 
	 * left join tbl_imageinfo tii on ti.id_image = tii.id_image 
	 * inner join tbl_imagedetails tid on tii.id_details = tid.id_details
	 * 
	 */
	@Override
	public DataTransferObject fetch(DataTransferObject dto) {
		// TODO Auto-generated method stub
		SelectQuery<Record> selectQuery = jooq.selectQuery();
		selectQuery.addSelect(TBL_IMAGE.NAME.as("name"));
		selectQuery.addSelect(TBL_IMAGE.PATH.as("path"));
		selectQuery.addSelect(TBL_IMAGEDETAILS.COMMENT.as("comment"));
		selectQuery.addFrom(TBL_IMAGE);
		selectQuery.addJoin(TBL_IMAGEINFO,JoinType.LEFT_OUTER_JOIN, TBL_IMAGE.ID_IMAGE.eq(TBL_IMAGEINFO.ID_IMAGE));
		selectQuery.addJoin(TBL_IMAGEDETAILS, TBL_IMAGEINFO.ID_DETAILS.eq(TBL_IMAGEDETAILS.ID_DETAILS));
		List<Record> results = selectQuery.fetch();
		
		return super.setResults(results);
	}

}
