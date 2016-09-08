package com.poc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dao.repository.ImageRepository;
import com.poc.dto.DataTransferObject;
import com.poc.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepo;
	
	@Override
	public void saveImage(DataTransferObject dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertImage(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataTransferObject selectImage(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return imageRepo.selectImage(dto);
	}

	@Override
	public DataTransferObject selectImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
