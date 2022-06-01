package com.aptech.t2010a.hellospring.controller;

import com.aptech.t2010a.hellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//http://localhost:8080/api/v1/students   |Get | return list student
//http://localhost:8080/api/v1/students   |Post | create new student
//http://localhost:8080/api/v1/students   |Delete | remove student
//http://localhost:8080/api/v1/students/1 |Get | find student by id
//http://localhost:8080/api/v1/students/1 |put | update student

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private static List<Student> list;
    public StudentController(){
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber( "A001").fullNumber("tien").build());
        list.add(Student.builder().rollNumber( "A002").fullNumber("tien1").build());
        list.add(Student.builder().rollNumber( "A003").fullNumber("tien2").build());
        list.add(Student.builder().rollNumber( "A004").fullNumber("tien3").build());
    }
    //CRUD
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return  list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return  student;
    }
//Path Variable
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id){
        int foundIndex =-1;
        for (int i =0; i< list.size(); i++){
            if (list.get(i).getRollNumber().equals((id))) {
                foundIndex = i;
                break;
               }
            }
        if (foundIndex ==-1){
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteByid(String id){
        int foundIndex =-1;
        for (int i =0; i< list.size(); i++){
            if (list.get(i).getRollNumber().equals((id))) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex ==-1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student UpdateStudent){
        int foundIndex =-1;
        for (int i =0; i< list.size(); i++){
            if (list.get(i).getRollNumber().equals((id))) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex ==-1){
            return null;
        }
        Student existing = list.get(foundIndex);
        existing.setFullNumber(UpdateStudent.getFullNumber());
        return  existing;
    }
}
