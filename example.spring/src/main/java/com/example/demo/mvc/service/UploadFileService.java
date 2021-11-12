package com.example.demo.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.domain.UploadFile;
import com.example.demo.mvc.repository.UploadFileRepository;
import com.example.demo.parameter.UploadFileParameter;

@Service
public class UploadFileService {
	
	  @Autowired
	    private UploadFileRepository fileRepository;

	    public void save(UploadFileParameter parameter) {
	        fileRepository.save(parameter);
	    }

	    public UploadFile get(int uploadFileSeq) {
	       return fileRepository.get(uploadFileSeq);
	    }

}
