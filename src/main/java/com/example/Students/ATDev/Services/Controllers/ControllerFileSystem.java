package com.example.Students.ATDev.Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Students.ATDev.Services.Entities.FileEntity;
import com.example.Students.ATDev.Services.Services.ServiceFileSystem;

import java.io.*;

@RestController
public class ControllerFileSystem {
    @Autowired
    private ServiceFileSystem fileService;

    @PostMapping("/uploadFile")
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileEntity fileEntity = fileService.saveFile(file);
        return ResponseEntity.ok(fileEntity);
    }

    @GetMapping("/getFile/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) throws IOException {
        FileEntity fileEntity = fileService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .body(fileEntity.getData());
    }

}
