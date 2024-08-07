package com.example.Students.ATDev.Services.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FileEntity {
    private String name;
    private String type;
    
    @JsonIgnore
    private byte[] data;
}