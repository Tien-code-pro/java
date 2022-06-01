package com.aptech.t2010a.hellospring.controller;

import com.aptech.t2010a.hellospring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/hello")
public class HelloController {

    @RequestMapping(path = "wold", method = RequestMethod.GET)
    public String say(){
        return "hello wold";
    }

    @RequestMapping(path = "talk", method = RequestMethod.GET)
    public String talk(){
        return "talk to hello wold";
    }


    @RequestMapping(path = "student", method = RequestMethod.GET)
    public Student student(){
        return Student.builder()
                .rollNumber("A002")
                .address("ha nam")
                .phone("01234448")
                .dob(LocalDateTime.of(2002,10,8,10,9))
                .build();
    }
}
