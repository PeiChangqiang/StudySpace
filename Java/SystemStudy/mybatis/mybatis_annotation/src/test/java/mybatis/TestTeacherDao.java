package mybatis;

import com.pcq.dao.TeacherDao;
import com.pcq.entity.Student;
import com.pcq.entity.Teacher;
import org.junit.Before;
import org.junit.Test;

public class TestTeacherDao {

    TeacherDao teacherDao;
    @Before
    public void init() {
        teacherDao = new TeacherDao();
    }

    @Test
    public void testFindTeacherById() {
        Teacher teacher = teacherDao.findTeacherById(1);
        System.out.println(teacher);
        for(Student stu : teacher.getStudents()) {
            System.out.println(stu);
        }
    }
}
