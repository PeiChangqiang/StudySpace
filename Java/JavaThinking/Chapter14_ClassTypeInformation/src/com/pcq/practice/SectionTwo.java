package com.pcq.practice;

import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionTwo {
    //exercise 1 注释掉Toy的默认构造器，会怎么样，为什么？
    //会产生实例初始化异常。因为newInstance需要默认的构造函数来产生实例。而Toy已经存在一个非默认的构造函数。因此无法实例化Toy。


    public static void main(String[] args) throws ClassNotFoundException {
        //exercise 5
       /* List<RShape> list = Arrays.asList(new RCircle(), new RTriangle(), new RSquare());
        for(RShape sh : list) {
            sh.draw();
            if(!(sh instanceof RCircle)) {
                sh.rotate(60);
            }
        }*/

       //exercise 6
       /* List<HShape> list = Arrays.asList(
                new HCircle(),new HTriangle(),
                new HSquare(), new HTriangle(),
                new HCircle(), new HSquare(),
                new HCircle(), new HSquare());
        HShape.highlight1(HCircle.class);
        HShape.highlight2(HCircle.class);
        for(HShape shape : list) {
            shape.draw();
        }
        System.out.println("--------------------------------------------------------------------------");
        HShape.highlight1(HShape.class);
        for(HShape shape : list) {
            shape.draw();
        }
        System.out.println("--------------------------------------------------------------------------");
        HShape.clearHighlight1(ArrayList.class);
        HShape.clearHighlight1(HCircle.class);
        for(HShape shape : list) {
            shape.draw();
        }*/


        //exercise 7
        /*for(String arg : args) {
            Class.forName(arg);
            System.out.println(arg);
        }*/

        //exercise 8
        RSquare square = new RSquare();
        printClassStructure(square);

        //exercise 9
        printClassFields(square.getClass());
    }


    public static void printClassStructure(Object object) {
        if(null != object) {
            printClassStructure(object.getClass());
        }
        return;
    }

    public static void printClassStructure(Class<?> c) {
        if(null == c) {
            return;
        }
        for(Class i : c.getInterfaces()) {
            System.out.println("interfaceName: " + i.getName());
            printClassStructure(i.getSuperclass());
        }
        System.out.println(c.getName());
       printClassStructure(c.getSuperclass());
    }


    public static void printClassFields(Class<?> c) {
        if(null == c) {
            return;
        }
        for(Field field : c.getDeclaredFields()) {
            System.out.println("fieldName : " + field.getName());
        }
    }
}


abstract class RShape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();

    void rotate(int degrees) {
        System.out.println("Rotating " + this + " by " + degrees + " degrees");
    }
}

class RCircle extends RShape {

    @Override
    public String toString() {
        return "RCircle";
    }
}

class RTriangle extends RShape {

    @Override
    public String toString() {
        return "RTriangle";
    }
}

class RSquare extends RShape implements A,B,C {

    private String abc;
    @Override
    public String toString() {
        return "Square";
    }
}

interface A {}
interface B {}
interface C {}

class HShape {
    boolean highlighted = false;
    public void highlight() {
        highlighted = true;
    }
    public void clearHighlight() {
        highlighted = false;
    }
    void draw() {
        System.out.println(this + "draw()");
    }

    static List<HShape> hShapes = new ArrayList<HShape>();
    HShape() {hShapes.add(this);}
    static void highlight1(Class<?> type) {
        for(HShape shape : hShapes) {
            if(type.isInstance(shape)) {
                shape.highlight();
            }
        }
    }
    static void clearHighlight1(Class<?> type) {
        for(HShape shape : hShapes) {
            if(type.isInstance(shape)) {
                shape.clearHighlight();
            }
        }
    }

    static void forEach(Class<?> type, String method) {
        try {
            Method m = HShape.class.getMethod(method, (Class<?>)null);
            for(HShape shape : hShapes) {
                if(type.isInstance(shape)) {
                    m.invoke(shape, (Class<?>)null);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void highlight2(Class<?> type) {
        forEach(type, "highlight");
    }

    static void clearHighlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }
    public String toString() {
        return getClass().getName() + (highlighted ? " highlighted " : " normal ");
    }
}

class HCircle extends HShape {}
class HTriangle extends HShape {}
class HSquare extends HShape {}




class Candy {
    static {
        System.out.println("loading candy");
    }
}

class Gum {
    static {
        System.out.println("loading gum");
    }
}

class Cookie {
    static {
        System.out.println("loading cookie");
    }
}