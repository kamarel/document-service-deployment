package com.documents.documentsservice.Service;


import com.documents.documentsservice.Entity.FileEntity;
import com.documents.documentsservice.Repository.FileEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileEntityService {

    private final FileEntityRepository fileEntityRepository;

    public FileEntity saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();

        FileEntity fileEntity = FileEntity.builder()
                .fileName(fileName)
                .fileType(fileType)
                .data(file.getBytes())
                .build();

        return fileEntityRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFile(Long id) {
        return fileEntityRepository.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return fileEntityRepository.findAll();
    }

    public void deleteFileById(Long id) {
        fileEntityRepository.deleteById(id);
    }
}
