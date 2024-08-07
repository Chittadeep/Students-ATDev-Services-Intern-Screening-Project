package com.example.Students.ATDev.Services.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Students.ATDev.Services.Entities.FileEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

@Service
public class ServiceFileSystem {
    private final String uploadDirectory = "uploads/"; 

    public FileEntity saveFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setType(file.getContentType());
        fileEntity.setData(file.getBytes());

        Path filePath = Paths.get(uploadDirectory, fileEntity.getName());
        System.out.println(filePath.toAbsolutePath());
        Files.write(filePath, fileEntity.getData());

        return fileEntity;
    }

    public FileEntity getFile(String id) throws IOException {
        Path filePath = Paths.get(uploadDirectory, id);
        byte[] data = Files.readAllBytes(filePath);

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(filePath.getFileName().toString());
        fileEntity.setData(data);

        return fileEntity;
    }

}
