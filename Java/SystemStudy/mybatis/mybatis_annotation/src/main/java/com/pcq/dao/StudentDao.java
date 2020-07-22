package com.pcq.dao;

import com.pcq.entity.Student;
import com.pcq.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao {
    public List<Student> findStudents() {
        SqlSession session = null;
        List<Student> students = new ArrayList<Student>();
        try {
            session = MyBatisUtil.getSqlSession();
            students = session.selectList("com.pcq.entity.StudentMapper.findStudents");
            return  students;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != session) {
                session.commit();
                session.close();
            }
        }
        return students;
    }

    public Student findStudentByCondition(Map<String, Object> map) {
        SqlSession session = null;
        Student student = null;
        try {
            session = MyBatisUtil.getSqlSession();
            student = session.selectOne("com.pcq.entity.StudentMapper.findStudentByCondition", map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != session) {
                session.close();
            }
        }
        return student;
    }
}
