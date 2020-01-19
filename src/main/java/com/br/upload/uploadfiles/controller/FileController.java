package com.br.upload.uploadfiles.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.upload.uploadfiles.dto.FileDTO;
import com.br.upload.uploadfiles.service.FileService;
import com.br.upload.uploadfiles.util.FileUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class FileController {
	@Autowired
    private FileService _fileService;

	@ApiOperation(value = "Return all list of files uploaded, can be filtered by name or not")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Return all files add"),
		    @ApiResponse(code = 500, message = "Generated a exception"),
		})
    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public List<FileDTO> getAll(@RequestParam(value= "name", required = false) String name) {
		if(name != null && !name.trim().isEmpty()) {
			return _fileService.findByName(name);	
		} else {
			return _fileService.findAll();
		}
    }
    
	@ApiOperation(value = "Add a new Upload File")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Return a id of the new file add"),
		    @ApiResponse(code = 500, message = "Generated a exception"),
		})
    @RequestMapping(value = "/file", method =  RequestMethod.POST)
    public ResponseEntity<Object> post(@Valid @RequestParam("file") MultipartFile file,@Valid @RequestParam("idUser") Long idUser){
        try {
        	//validate contenttype
        	if(!FileUtil.fileContentTypeIsValid(file.getContentType())) {
        		throw new IllegalArgumentException("Incorrect file type (JPEG/JFIF,GIF, BMP or PNG required).");
            } 
        	
        	//save file
			FileDTO fileSaved = _fileService.save(file, idUser);
			return ResponseEntity.ok().body(fileSaved.getId());
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
	@ApiOperation(value = "Remove a file uploaded")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Return all files add"),
		    @ApiResponse(code = 404, message = "Not found file"),
		    @ApiResponse(code = 500, message = "Generated a exception"),
		})
    @RequestMapping(value = "/file/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
		try {
	        if(_fileService.delete(id)) {
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
}
