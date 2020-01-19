package com.br.upload.uploadfiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.br.upload.uploadfiles.entity.User;
import com.br.upload.uploadfiles.repository.UserRepository;

@SpringBootApplication
public class UploadFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFilesApplication.class, args);
	}
	
	/**
	 * 
	 * @param userRepository
	 * @return Insert a user 
	 */
	@Bean
    public CommandLineRunner insertDataPreLoad(UserRepository userRepository) {
        return args -> { 
        	userRepository.save(new User(Long.valueOf(1), "Guilherme"));
        };
    }

}
