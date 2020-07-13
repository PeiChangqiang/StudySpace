package mybatis;

import com.pcq.dao.StudentDao;
import com.pcq.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestStudentDao {

    StudentDao studentDao;

    @Before
    public void init() {
        studentDao = new StudentDao();
    }

    @Test
    public void testFindStudents() {
        List<Student> students = studentDao.findStudents();
        for(Student stu : students) {
            System.out.println(stu.getId() + "," + stu.getName());
        }
    }

    @Test
    public void testFindStudentByCondition() {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("name", "甫");
        Student student = studentDao.findStudentByCondition(map);
        System.out.println(student);
    }
}
