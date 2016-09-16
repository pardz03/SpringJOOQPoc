package com.poc.service;

import org.springframework.stereotype.Service;

import com.poc.dto.DataTransferObject;

@Service
public interface ImageService {
	void saveImage(DataTransferObject dto);
	void saveImageDetails(DataTransferObject dto);
	void updateImage(DataTransferObject dto);
	void updateImageDetails(DataTransferObject dto);
	void deleteImage(DataTransferObject dto);
	void deleteImageDetails(DataTransferObject dto);
	DataTransferObject selectImage(DataTransferObject dto);
	DataTransferObject selectImageDetails(DataTransferObject dto);
	
	DataTransferObject subSelectExample(DataTransferObject dto);
	DataTransferObject joinAndLeftJoinUsingSelectQuery(DataTransferObject dto);
}
