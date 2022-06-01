package com.aptech.t2010a.hellospring.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    public void testCreateStudent(){
        Student student = new Student();
        student.setRollNumber("A001");
        student.setFullNumber("Tien");
        student.setAddress("ha nam");
        System.out.println(student.toString());

        System.out.println(Student.builder()
                .rollNumber("A002")
                .address("ha nam")
                .phone("01234448")
                .build().toString());
    }


}