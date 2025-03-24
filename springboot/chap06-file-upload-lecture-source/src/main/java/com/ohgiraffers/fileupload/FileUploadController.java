package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    @PostMapping("/single-file")
    public String singleFileUpload(
            @RequestParam String singleFileDescription,
            @RequestParam MultipartFile singleFile){
        System.out.println("singleFileDescription = " + singleFileDescription);
        System.out.println("singleFile = " + singleFile);

        File dir = new File(filePath);
        if(!dir.exists()) dir.mkdirs();

        String savedName = generateSavedFileName(singleFile);

        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "result";
    }

    private String generateSavedFileName(MultipartFile file) {

        String originFileName = file.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;

    }
}
