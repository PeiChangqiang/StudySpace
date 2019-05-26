import com.sun.org.apache.xpath.internal.functions.FuncSubstring;

public class Main {

    public static void main(String[] args) {
        new Main().stringTest();
        Stu stu = new Stu("Jack",20,'M');
        System.out.println(stu.getAge());
        new Main().testObjParam(stu);
        System.out.println(stu.getAge());
        new CommonTest().test1();

    }


    void  stringTest() {
        String a = "string";
        System.out.println(a.charAt(0));
        StringBuffer sb = new StringBuffer();
        sb.append(a);

//        int[] arr = new int[100];
//        for(int x : arr) {
//            System.out.println(x);
//        }
//        read_break:
//        for(int i = 0; i< 10; i++) {
//            for(int j = 0; j < 20; j++) {
//                if(j >10) {
//                    System.out.println("j : " + j);
//                    break read_break;
//                }
//
//            }
//        }
        int x = 2;double y = 0.1;
        testParam(x,y);
        System.out.println("after x,y :" + x + "," + y);

    }
    void testParam(int x,double y) {
        x += 3;
        System.out.println(x);
        System.out.println(y);
    }

    void testObjParam(Stu stu) {
        Stu tempStu = stu;
        tempStu.grow();
    }

}



class Stu {
    private static Integer nextId = 0;
    private Integer id;
    private String name;
    private Integer age;
    private Character sex;

    {
        id= nextId;
        nextId++;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public Stu(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void grow() {
        this.age++;
    }

    public Integer getAge() {
        return this.age;
    }
}
class CommonTest {
    void test1() {
        for(int i = 0; i < 5; i++) {
            System.out.println(new Stu("a",5,'M'));
        }
        Teacher t = Teacher.getTeacherInstance();
        System.out.println(t.toString());
        Teacher t2 = Teacher.getTeacherInstance();
        t2.setAge(45);
        System.out.println(t.toString());
        System.out.println(t2.toString());
    }
}

class Teacher {
    private static Integer nextId = 0;
    private Integer id;
    private static Teacher teacher;
    private String name = "Tony";
    private Integer age = 38;
    private Character sex = 'M';

    {
        id = nextId;
        nextId++;
    }
    private  Teacher() {
    }
    public synchronized static Teacher getTeacherInstance() {
        if(teacher == null) {
            teacher = new Teacher();
        }
        return teacher;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id : " + id + ",name : " + name + ",age : " + age + ",sex:" + sex + ",nextId : " + nextId;
    }
}