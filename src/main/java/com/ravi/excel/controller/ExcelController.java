package com.ravi.excel.controller;

import com.ravi.excel.helper.ExcelHelper;
import com.ravi.excel.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.save(file);

                message = "The file successfully got Uploaded: " + file.getOriginalFilename();
                return message;
            } catch (Exception e) {
                message = "Sorry Could not upload the file: " + file.getOriginalFilename();
                return message;

            }
        }
        message = "Upload an excel file!";
        return message;
    }
}
