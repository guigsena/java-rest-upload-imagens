package com.br.upload.uploadfiles.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.upload.uploadfiles.dto.FileDTO;
import com.br.upload.uploadfiles.entity.File;
import com.br.upload.uploadfiles.repository.FileRepository;
import com.br.upload.uploadfiles.util.FileUtil;

@Service
public class FileService {

	@Autowired
    private FileRepository _fileRepository;
	
	/**
	 * 
	 * @return Return all itens
	 */
	public List<FileDTO> findAll() {
		return _fileRepository.findAll().stream().map(
		        item -> FileUtil.converterToDTO(item)
		).collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param id
	 * @return return true if file was excluded
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception {
    	Optional<File> file = findById(id);
        if(file.isPresent()){
        	_fileRepository.delete(file.get());
            return true;
        }
       return false;
    	
    }
    
    /**
     * 
     * @param id
     * @return file by id
     */
    private Optional<File> findById(Long id) {
		return _fileRepository.findById(id);
	}
	
    /**
     * 
     * @param multipartFile
     * @return save File
     * @throws IOException
     */
	public FileDTO save(MultipartFile multipartFile, Long idUser) throws IOException {
		return FileUtil.converterToDTO(_fileRepository.save(FileUtil.converterMultipartFileToFile(multipartFile, idUser)));
	}

	/**
	 * 
	 * @param name
	 * @return list of all files with a name
	 */
	public List<FileDTO> findByName(String name) {
		return _fileRepository.findByName(name).stream().map(
		        item -> FileUtil.converterToDTO(item)
		).collect(Collectors.toList());
	}
	
}
