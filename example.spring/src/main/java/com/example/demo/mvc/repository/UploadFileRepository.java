package com.example.demo.mvc.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.UploadFile;
import com.example.demo.parameter.UploadFileParameter;

@Repository
public interface UploadFileRepository {
	
	   void save(UploadFileParameter parameter);

	    UploadFile get(int uploadFileSeq);

}
