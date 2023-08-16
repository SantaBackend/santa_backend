package com.likelion.santa.controller;

import com.likelion.santa.service.AwsS3Service;
import com.likelion.santa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/upload")
public class AwsS3Controller {

    @Autowired
    AwsS3Service awsS3Service;
    @Autowired
    BoardService boardService;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(awsS3Service.upload(file));
    }

    @PatchMapping("/mntnImage/{id}")
    public ResponseEntity<String> uploadMntnImage(@RequestParam("file") MultipartFile file, @PathVariable Long id){
        return ResponseEntity.ok(boardService.mntnImageUpload(id, awsS3Service.upload(file)));
    }

    @PatchMapping("/hkImage/{id}")
    public ResponseEntity<String> uploadHkImage(@RequestParam("file") MultipartFile file, @PathVariable Long id){
        return ResponseEntity.ok(boardService.hkImageUpload(id, awsS3Service.upload(file)));
    }
}
