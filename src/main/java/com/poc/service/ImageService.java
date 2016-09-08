package com.poc.service;

import org.springframework.stereotype.Service;

import com.poc.dto.DataTransferObject;

@Service
public interface ImageService {
	void saveImage(DataTransferObject dto);
	void saveImageDetails(DataTransferObject dto);
	void updateImage(DataTransferObject dto);
	void updateImageDetails(DataTransferObject dto);
	void insertImage(DataTransferObject dto);
	void insertImageDetails(DataTransferObject dto);
	DataTransferObject selectImage(DataTransferObject dto);
	DataTransferObject selectImageDetails(DataTransferObject dto);
}
