package com.br.upload.uploadfiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.upload.uploadfiles.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	List<File> findByName(String name);

}
