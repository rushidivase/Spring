package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer>{

}
