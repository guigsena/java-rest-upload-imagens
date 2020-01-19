package com.br.upload.uploadfiles;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.br.upload.uploadfiles.controller.FileController;
import com.br.upload.uploadfiles.dto.FileDTO;
import com.br.upload.uploadfiles.enums.StatusFileEnum;
import com.br.upload.uploadfiles.util.FileUtil;


@AutoConfigureMockMvc
@SpringBootTest
class UploadFilesApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FileController _fileController;
	
	@Test
	public void shouldListAllFiles() throws Exception {
		//given
		FileDTO file = new FileDTO(Long.valueOf(1), "file.jpeg", "image/jpeg", "123", Long.valueOf(1), StatusFileEnum.COMPLETE.status());
		List<FileDTO> all =Arrays.asList(file); 

		//when
		given(_fileController.getAll(null)).willReturn(all);

       //then
		mvc.perform(get("/file")
			.contentType(APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(file.getName())));
	}
	
	@Test
	public void shouldPutFile() throws Exception {
		//given
		MockMultipartFile file = new MockMultipartFile("file", "filename.jpeg", "form-data", "somefile".getBytes());
		//when
		mvc.perform(MockMvcRequestBuilders.multipart("/file")
        		.file(file)
        		.param("idUser", "30"))
				.andExpect(status().isOk());
			
	}
	
	@Test
	public void shouldDeleteFile() throws Exception {
		//given
		Long idFile = Long.valueOf(1);

		this.mvc.perform(MockMvcRequestBuilders
	            .delete("/file/{id}", idFile)
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	@Test
	public void contentTypeNotValid() throws Exception {
		// Given
		String fileContentType = "image/pdf";
	 
		// When
		boolean invalid =  FileUtil.fileContentTypeIsValid(fileContentType);
	 
		// Then
		assertEquals( invalid, Boolean.FALSE );
	}	

}
