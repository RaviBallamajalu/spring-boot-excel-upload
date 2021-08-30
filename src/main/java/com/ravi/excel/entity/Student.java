package com.ravi.excel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name="STUDENT_NAME")
    private String name;

    @Column(name="MOBILE_NUMBER")
    private Long mobileNumber;
}
