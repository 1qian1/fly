package com.example.demo.contorller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@RestController
public class ImageController {

    private static final String UPLOAD_DIR = "C:\\Users\\29276\\Desktop\\img\\"; // 修改为实际保存路径

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("上传失败，请选择文件");
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String randomFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

        try {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            file.transferTo(new File(UPLOAD_DIR + randomFileName));

            String imageUrl = "http://localhost:8084/img/" + randomFileName; // 图片访问路径

            return ResponseEntity.ok( imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("上传失败！" + e.getMessage());
        }
    }

    @GetMapping("/img/{fileName:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        try {
            File file = new File(UPLOAD_DIR + fileName);
            byte[] imageBytes = Files.readAllBytes(file.toPath());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
