package Homeworks.Lesson2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Lesson2_ReflactionApi {
    /*
    Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
     */


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> stringClass = Class.forName("java.lang.String");

        Method[]  methods = stringClass.getDeclaredMethods();
        for (Method method:methods)
            System.out.println("Метод: " + method.getName());

    }


}
