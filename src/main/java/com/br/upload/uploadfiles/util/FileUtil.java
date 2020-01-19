package com.br.upload.uploadfiles.util;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.br.upload.uploadfiles.dto.FileDTO;
import com.br.upload.uploadfiles.entity.File;
import com.br.upload.uploadfiles.entity.User;
import com.br.upload.uploadfiles.enums.ContentTypeEnum;
import com.br.upload.uploadfiles.enums.StatusFileEnum;


public class FileUtil {

	private static final long MAX_SIZE_FILE = 5000000;//5mb

	public static File converterMultipartFileToFile(MultipartFile multipartFile, Long idUser) throws IOException {
		return new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(), converterBytesToBase64(multipartFile.getBytes()), new User(idUser), StatusFileEnum.COMPLETE);
	}

	public static String converterBytesToBase64(byte[] fileContent) {
        return Base64.getEncoder().encodeToString(fileContent);
	}
	
	public static FileDTO converterToDTO(File file) {
		return new FileDTO(file.getId(), file.getName(), file.getContentType(), file.getBase64(), file.getUser().getId(), file.getStatus().status());
	}

	public static boolean fileContentTypeIsValid(String contentType) {
		for(ContentTypeEnum en: ContentTypeEnum.values()) {
			if(en.contentType().equals(contentType)) {
				return true;
			}
		}
		return false;
	}

	//this valiation is doing in application.properties
	public static boolean fileSizeIsValid(long size) {
		if(size <= MAX_SIZE_FILE) {
			return true;
		}
		return false;
	}
}

