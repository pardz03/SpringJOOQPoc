package com.poc.dao.repository;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dao.domainfactory.DomainFactory;
import com.poc.dao.gateway.ImageGateway;
import com.poc.dto.DataTransferObject;
import com.poc.model.Image;

@Repository
@Transactional
public class ImageRepository {
	
	@Autowired
	DomainFactory<Image> imageFactory;
	
	@Autowired
	ImageGateway imgGateway;
	
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
}
