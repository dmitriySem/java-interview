package Homeworks.Lesson3;

import Seminars.Lesson3.task1.UserData;

import java.io.*;

public class Serialization{


        /*
        Задание 1: Создайте класс Person с полями name и age.
        Реализуйте сериализацию и десериализацию этого класса в файл.
        */


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person userData = new Person("Dima", 31);

        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(userData);
            System.out.println("Данные сериализованы");
        }

        try (FileInputStream fileInputStream = new FileInputStream("userdata.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            userData = (Person) objectInputStream.readObject();
            System.out.println("Данные десериализованы");
        }

        System.out.println("Имя " + userData.getName());
        System.out.println("Возраст " + userData.getAge());
    }


}
