package com.documents.documentsservice.Controller;


import com.documents.documentsservice.Entity.FileEntity;
import com.documents.documentsservice.Service.FileEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileEntityController {

    private final FileEntityService fileEntityService;

    // Upload a file
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileEntity fileEntity = fileEntityService.saveFile(file);
        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully: " + fileEntity.getFileName());
    }

    // Download a file
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileEntityService.getFile(id);
        if (fileEntityOptional.isPresent()) {
            FileEntity fileEntity = fileEntityOptional.get();
            String mimeType = fileEntity.getFileType() != null ? fileEntity.getFileType() : "application/octet-stream";

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                    .body(fileEntity.getData());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/all")
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> allFiles = fileEntityService.getAllFiles();
        return ResponseEntity.ok(allFiles);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFileById(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileEntityService.getFile(id);

        if (fileEntityOptional.isPresent()) {
            fileEntityService.deleteFileById(id);
            return ResponseEntity.ok("File deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found.");
        }
    }
}
