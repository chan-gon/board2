package com.example.demo.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.configuration.GlobalConfig;
import com.example.demo.configuration.exception.BaseException;
import com.example.demo.configuration.http.BaseResponse;
import com.example.demo.configuration.http.BaseResponseCode;
import com.example.demo.mvc.service.UploadFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "파일 API")
@RequestMapping("/file")
public class FIleController {
	
	 Logger logger = LoggerFactory.getLogger(getClass());

	    @Autowired
	    private GlobalConfig config;

	    @Autowired
	    private UploadFileService fileService;

	    /**
	     * 업로드 리턴
	     */
	    @PostMapping("/save")
	    @ApiOperation(value="업로드",notes = "")
	    public BaseResponse<Boolean>save(@RequestParam("uploadFile") MultipartFile multipartFile){
	        if(multipartFile == null || multipartFile.isEmpty()){
	            throw new BaseException(BaseResponseCode.DATA_IS_NULL);
	        }
	        //날짜폴더 추가
	        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	        logger.debug("config : {}", config);
	        String uploadFilePath = config.getUploadFilePath()+ currentDate + "/";
	        logger.debug("uploadFilePath : {}",uploadFilePath);

	        String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") +1, multipartFile.getOriginalFilename().length());
	        String filename = UUID.randomUUID().toString()+"."+ prefix;
	        String pathname = uploadFilePath + filename;

	        File folder = new File(uploadFilePath);
	        if(!folder.isDirectory()){
	            folder.mkdirs();
	        }
	        File dest = new File(pathname);
	        try {
	            multipartFile.transferTo(dest);
	        } catch ( IllegalStateException | IOException e) {
	            e.printStackTrace();
	        }
	        return new BaseResponse<Boolean>(true);
	    }
}
