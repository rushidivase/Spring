package com.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileEntity {

	@Id
	@GeneratedValue
	private long id;

	private String fileName;

	@Lob
	private byte[] data;

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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public FileEntity(String fileName, byte[] data) {
		this.fileName = fileName;
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + "]";
	}

	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
