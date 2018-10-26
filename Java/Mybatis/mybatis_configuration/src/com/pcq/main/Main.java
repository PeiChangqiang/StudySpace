package com.pcq.main;

import com.pcq.entity.Student;
import com.pcq.mapper.StudentMapper;
import com.pcq.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.findStudentsByName("k");
            Student stu = studentMapper.findStudentById("20081103");
            System.out.println("sName:" + stu.getsName() + ",sId:" + stu.getsId());
            for(Student student : studentList) {
                System.out.println("sName: " + student.getsName() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
