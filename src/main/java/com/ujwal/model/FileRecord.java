package com.ujwal.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UPLOADED_FILES")
public class FileRecord {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="fileName", nullable = false)
	private String fileName;
	
	@Column(name="processed", nullable = false)
	private boolean processed;
	
	@Column(name="error_message")
	private String errorMessage;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="exchange_name")
	private String exchangeName;
	
	@Column(name="records_processed")
	private int recordsProcessed;
	
	@Column(name="total_records")
	private String totalRecords;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fromDate")
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="toDate")
	private Date toDate;
	
	@JsonIgnore
	@Lob
	@Column(name="file_data")
	private Blob fileData;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public int getRecordsProcessed() {
		return recordsProcessed;
	}

	public void setRecordsProcessed(int recordsProcessed) {
		this.recordsProcessed = recordsProcessed;
	}

	public String getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Blob getFileData() {
		return fileData;
	}

	public void setFileData(Blob fileData) {
		this.fileData = fileData;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
