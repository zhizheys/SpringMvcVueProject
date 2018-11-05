package com.me.service;

import java.util.List;

import org.apache.lucene.document.Document;

import com.me.entity.LuceneBook;

public interface LuceneService {

	public List<LuceneBook> getAllLuceneBook();
	
	//public void createIndex(List<Document> documentList);
	
	public void dbDataToLucene();

	public void fileDataToLucene();
}
