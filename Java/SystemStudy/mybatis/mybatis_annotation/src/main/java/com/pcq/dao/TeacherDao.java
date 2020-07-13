package com.pcq.dao;

import com.pcq.entity.Teacher;
import com.pcq.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class TeacherDao {
    public Teacher findTeacherById(Integer id) {
        SqlSession session = null;
        Teacher teacher = null;
        try {
            session = MyBatisUtil.getSqlSession();
            teacher = session.selectOne("com.pcq.entity.TeacherMapper.findTeacherById", id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != session) {
                session.close();
            }
        }
        return teacher;
    }
}
