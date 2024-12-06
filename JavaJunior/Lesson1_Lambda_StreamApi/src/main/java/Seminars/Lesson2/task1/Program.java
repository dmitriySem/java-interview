package Seminars.Lesson2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Program {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> personalClass = Class.forName("Seminars.Lesson2.task1.Person");

        //Получить список всех полей.
        Field[]  fields = personalClass.getDeclaredFields();
        for (Field field:fields){
            System.out.println("Поле: " + field.getName());
        }

        //Получение список всех конструкторов
        Constructor[] constructors = personalClass.getConstructors();

        Object personInstance = constructors[0].newInstance(null);

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Alice");

    }
}
