package Seminars.Lesson2.task2;

import java.lang.reflect.Field;

public class Program {

    /**
    Задача 2: Применение Reflecttion Api в рфзработке
    ======================================================
    <p>
    Реализуйте обобщенный метод, который принимает объект и выводит в консоль значения всех полей.
    Создайте класс Car с различными полями.
    Применити Reflection Api для вывода значений полей созданного объейкта класса Car
    с использованием ранее созданного метода.
     **/

    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Toyota", "blue", 2012);
        task2(car);
    }

    private static <T> void task2(T obj) throws IllegalAccessException {
        Class<?> obClass = obj.getClass();

        Field[] fields = obClass.getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true); // разрешает доступ к закрытым полям
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
    }
}
