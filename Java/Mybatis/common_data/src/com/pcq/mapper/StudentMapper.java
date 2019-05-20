package com.pcq.mapper;

import com.pcq.entity.Student;

import java.util.List;

public interface StudentMapper {
    Student findStudentById(String sId);
    int deleteStudentById(String sId);
    int updateStudent(Student student);
    int insertStudent(Student student);
    List<Student> findStudentsByName(String sName);
}
