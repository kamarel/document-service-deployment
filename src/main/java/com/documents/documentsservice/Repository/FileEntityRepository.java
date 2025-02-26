package com.documents.documentsservice.Repository;


import com.documents.documentsservice.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
}
