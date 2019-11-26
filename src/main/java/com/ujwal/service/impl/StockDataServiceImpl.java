package com.ujwal.service.impl;

import java.io.IOException;
import java.sql.Blob;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ujwal.model.FileRecord;
import com.ujwal.repository.FileRecordRepository;
import com.ujwal.service.StockDataService;

@Service
public class StockDataServiceImpl implements StockDataService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	FileRecordRepository repository;
	
	@Transactional
	public FileRecord saveFile(MultipartFile file) throws IOException {
		FileRecord record = new FileRecord();
		record.setFileName(file.getName());
		Session session = entityManager.unwrap(Session.class);
		Blob blob = Hibernate.getLobCreator(session).createBlob(file.getBytes());
		record.setFileData(blob);
		return repository.save(record);
	}
}