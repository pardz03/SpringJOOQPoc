package com.poc.dao.repository;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dao.factory.DomainFactory;
import com.poc.dao.gateway.ImageDetailsGateway;
import com.poc.dao.gateway.ImageFullDetailsGateway;
import com.poc.dao.gateway.ImageGateway;
import com.poc.dao.gateway.ImageInfoGateway;
import com.poc.dao.gateway.ImageJoinAndLeftJoinUsingSelectQueryGateway;
import com.poc.dao.gateway.ImageSubSelectExampleGateway;
import com.poc.db.tables.records.TblImagedetailsRecord;
import com.poc.dto.DataTransferObject;
import com.poc.model.FullImageDetails;
import com.poc.model.Image;

@Repository
@Transactional
public class ImageRepository {
	
	@Autowired
	DomainFactory<Image> imageFactory;
	
	@Autowired
	DomainFactory<FullImageDetails> fullImageDetailsFactory;
	
	@Autowired
	ImageGateway imgGateway;
	
	@Autowired 
	ImageFullDetailsGateway imageFullDetailsGateway;
	
	@Autowired
	ImageSubSelectExampleGateway imageSubSelectExampleGateway;
	
	@Autowired
	ImageInfoGateway imageInfoGateway;
	
	@Autowired
	ImageDetailsGateway imageDetailsGateway;
	
	@Autowired
	ImageJoinAndLeftJoinUsingSelectQueryGateway joinGateway;
	
	public DataTransferObject selectImage(DataTransferObject dto){

		DataTransferObject fetchResult = imgGateway.fetch(dto);
		
		List<Image> image = new ArrayList<Image>();	
		for(Record r : fetchResult.getResults()){
			Image i = imageFactory.make(r, Image.class);
			image.add(i);
		}
		fetchResult.setImagelist(image);

		return fetchResult;
	}
	
	public void saveImage(DataTransferObject dto){
		imgGateway.insert(dto);
	}
	
	public void deleteImage(DataTransferObject dto){
		imgGateway.delete(dto);
	}
	
	public void updateImage(DataTransferObject dto){
		imgGateway.update(dto);
	}
	
	public DataTransferObject selectFullImageDetails(DataTransferObject dto){
		DataTransferObject fetchResult = imageFullDetailsGateway.fetch(dto);
		
		List<FullImageDetails> image = new ArrayList<FullImageDetails>();
		for(Record r : fetchResult.getResults()){
			FullImageDetails i = fullImageDetailsFactory.make(r, FullImageDetails.class);
			image.add(i);
		}
		fetchResult.setFullImageDetails(image);
		return fetchResult;
	}
	
	public DataTransferObject subSelectExample(DataTransferObject dto){
		DataTransferObject fetchResult = imageSubSelectExampleGateway.fetch(dto);
		List<FullImageDetails> image = new ArrayList<FullImageDetails>();
		for(Record r : fetchResult.getResults()){
			FullImageDetails i = fullImageDetailsFactory.make(r, FullImageDetails.class);
			image.add(i);
		}
		fetchResult.setFullImageDetails(image);
		return fetchResult;
	}
	
	public DataTransferObject joinAndLeftJoinUsingSelectQuery(DataTransferObject dto){
		DataTransferObject fetchResult = joinGateway.fetch(dto);
		List<FullImageDetails> image = new ArrayList<FullImageDetails>();
		for(Record r : fetchResult.getResults()){
			FullImageDetails i = fullImageDetailsFactory.make(r, FullImageDetails.class);
			image.add(i);
		}
		fetchResult.setFullImageDetails(image);
		return fetchResult;
	}

	public void insertImageDetails(DataTransferObject dto){
		imageDetailsGateway.insert(dto);
		FullImageDetails fullImageDetail = dto.getFullImageDetail();
		fullImageDetail.setImageDetailsId(dto.getImagedetailRecordResult().getIdDetails());
		imageInfoGateway.insert(dto);
	}
}
