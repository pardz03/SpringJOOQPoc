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
		imageRepo.saveImage(dto);
	}

	@Override
	public void saveImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageRepo.updateImage(dto);
	}

	@Override
	public void updateImageDetails(DataTransferObject dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(DataTransferObject dto) {
		// TODO Auto-generated method stub
		imageRepo.deleteImage(dto);
	}

	@Override
	public void deleteImageDetails(DataTransferObject dto) {
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
		return imageRepo.selectFullImageDetails(dto);
	}

	@Override
	public DataTransferObject subSelectExample(DataTransferObject dto) {
		// TODO Auto-generated method stub
		return imageRepo.subSelectExample(dto);
	}

	@Override
	public DataTransferObject joinAndLeftJoinUsingSelectQuery(
			DataTransferObject dto) {
		// TODO Auto-generated method stub
		return imageRepo.joinAndLeftJoinUsingSelectQuery(dto);
	}

}
