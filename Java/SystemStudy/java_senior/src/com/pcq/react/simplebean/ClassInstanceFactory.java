package com.pcq.react.simplebean;

import com.pcq.util.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassInstanceFactory {
    public static <T> T create(Class<?> clazz, String value) {
        Object object = null;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(object, value);
            return (T)object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}


/**
 * ����bean���������ֵ
 * ��ʽ"param1:val1|param2:val2..."
 */
class BeanUtils {
    public static void setValue(Object obj, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        String[] keyVals = value.split("\\|");//���������������ֵ�ļ�ֵ��
        for(String temp : keyVals) {
            String[] args = temp.split(":");
            Field field = obj.getClass().getDeclaredField(args[0]);
            Method setMethod = obj.getClass().getMethod("set" + StringUtil.initCap(args[0]), field.getType());//���set��������
            Object val = convertAttributeValueType(field.getType().getName(), args[1]);
            setMethod.invoke(obj, val);
        }
    }

    /**
     * ת����������ֵ
     * @return
     */
    private static Object convertAttributeValueType(String type, String value) {
        //System.out.println("type = " + type + ", value = " + value);
        if("long".equals(type) || "java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        } else if("double".equals(type) || "java.lang.Double".equals(type)) {
            return Double.parseDouble(value);
        } else if("int".equals(type) || "java.lang.Integer".equals(type)) {
            return Integer.parseInt(value);
        }
        else {
            return value;
        }
    }
}