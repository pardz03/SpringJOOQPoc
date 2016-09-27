package com.poc.dto;

import java.util.List;

import org.jooq.Record;

import com.poc.db.tables.records.TblImagedetailsRecord;
import com.poc.model.FullImageDetails;
import com.poc.model.Image;

public class DataTransferObject {
	private List<Record> results;
	private List<Image> imagelist;
	private List<FullImageDetails> fullImageDetails;
	private Image image;
	private FullImageDetails fullImageDetail;
	
	//datastorage for result record. see ImageDetailsGateway.java insert method
	private TblImagedetailsRecord imagedetailRecordResult;

	public List<Record> getResults() {
		return results;
	}

	public void setResults(List<Record> results) {
		this.results = results;
	}

	public List<Image> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<Image> imagelist) {
		this.imagelist = imagelist;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<FullImageDetails> getFullImageDetails() {
		return fullImageDetails;
	}

	public void setFullImageDetails(List<FullImageDetails> fullImageDetails) {
		this.fullImageDetails = fullImageDetails;
	}

	public FullImageDetails getFullImageDetail() {
		return fullImageDetail;
	}

	public void setFullImageDetail(FullImageDetails fullImageDetail) {
		this.fullImageDetail = fullImageDetail;
	}

	public TblImagedetailsRecord getImagedetailRecordResult() {
		return imagedetailRecordResult;
	}

	public void setImagedetailRecordResult(TblImagedetailsRecord imagedetailRecordResult) {
		this.imagedetailRecordResult = imagedetailRecordResult;
	}


}
