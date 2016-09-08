package com.poc.dto;

import java.util.List;

import org.jooq.Record;

import com.poc.model.Image;

public class DataTransferObject {
	private List<Record> results;
	private List<Image> imagelist;

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
}
