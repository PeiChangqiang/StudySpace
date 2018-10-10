package com.pcq.mapper;

import com.pcq.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper2 {
    @Select("SELECT sId,sName,sAge,sSex FROM student WHERE sId = #{id}")
    Student findStudentById(String sId);
}
