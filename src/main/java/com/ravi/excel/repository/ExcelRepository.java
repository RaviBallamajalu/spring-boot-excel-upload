package com.ravi.excel.repository;

import com.ravi.excel.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelRepository extends JpaRepository<Student,Integer> {
}
