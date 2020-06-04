package com.always.servlet;

import java.lang.reflect.Constructor;

/**
 * @ClassName: TomcatTest
 * @Description:
 * @Author: 余霜
 * @Date: 2020/03/14 10:32
 * @Version: V1.0
 **/
public class TomcatTest {
    public static void main(String[] args) {
        String str = "com.always.servlet.MyServlet";
        try {
            Class<Object> clazz = (Class<Object>) Class.forName(str);
            Constructor<Object> constructor =  clazz.getConstructor();
            System.out.println(constructor);
            Object object = constructor.newInstance();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
