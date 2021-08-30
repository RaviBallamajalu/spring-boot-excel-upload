package com.ravi.excel.service;

import com.ravi.excel.entity.Student;
import com.ravi.excel.helper.ExcelHelper;
import com.ravi.excel.repository.ExcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelRepository excelRepository;
    public void save(MultipartFile file) {
        try {
            List<Student> tutorials = ExcelHelper.excelToStudents(file.getInputStream());
            excelRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
