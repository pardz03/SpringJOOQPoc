package com.poc.dao.gateway;

import java.util.List;

import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.stereotype.Component;

import com.poc.dto.DataTransferObject;

import static com.poc.db.tables.TblImage.TBL_IMAGE;
import static com.poc.db.tables.TblImagedetails.TBL_IMAGEDETAILS;
import static com.poc.db.tables.TblImageinfo.TBL_IMAGEINFO;

@Component
public class ImageSubSelectExampleGateway extends BaseGateway{

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
	 * 
	 * this example is equivalent to
	 * 
	 * select * from tbl_imageinfo tii,tbl_imagedetails tid where tii.id_details = tid.id_details and tii.id_image = (select id_image from tbl_image where id_image=22)
	 * 
	 */
	@Override
	public DataTransferObject fetch(DataTransferObject dto) {
		// TODO Auto-generated method stub
		Result<Record1<Integer>> id_image =
				jooq
					.select(TBL_IMAGE.ID_IMAGE)
					.from(TBL_IMAGE)
					.where(TBL_IMAGE.ID_IMAGE.eq(Integer.parseInt(dto.getImage().getId())))
					.fetch();
		
		List<Record> results = jooq
				.select(TBL_IMAGEDETAILS.ID_DETAILS)
				.select(TBL_IMAGEDETAILS.COMMENT.as("comment"))
				.from(TBL_IMAGEINFO)
				.leftOuterJoin(TBL_IMAGEDETAILS).on(TBL_IMAGEINFO.ID_DETAILS.eq(TBL_IMAGEDETAILS.ID_DETAILS))
				.where(TBL_IMAGEINFO.ID_IMAGE.in(id_image))
				.fetch();
		
		DataTransferObject returnDTO = new DataTransferObject();
		returnDTO.setResults(results);
		return returnDTO;
	}

}
