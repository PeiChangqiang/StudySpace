package com.pcq.main;

import com.pcq.entity.Student;
import com.pcq.mapper.StudentMapper;
import com.pcq.util.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.findStudentsByName("k");
            Student stu = studentMapper.findStudentById("20081103");
            log.info("sName:" + stu.getsName() + ",sId:" + stu.getsId());
            for(Student student : studentList) {
                log.info("sName: " + student.getsName() + "\n");
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
