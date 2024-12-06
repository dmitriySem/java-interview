package Seminars.Lesson3.task1;

import java.io.*;

public class Program {


    /*
*	Задача 1
*	<р>
*	Создайте класс UserData с поляки String name, inт age, transient String password
*   Попе password должно быть отмечено ключем словом transient
*	Реализуйте интерфейс Seriazeble в вашем классе
*	В методе main создоиге экземпляр класса UserData и инициализируйте его данными.
*   Сериализуйте этот объект в файл используя ObjectOutputStream в сочетании с FileOutputStream»
*	<р>

* *	<р>
    Задача 2
*   просериализуйте объект из ранее созданного файла обратно в объект Java,
*	используя ObjectInputStream в сочетании с FilelInputStream
*	Выведите данные десериализованного объекта UserData
*	Сравните данные оо сериализации и после десериализации.
*   особенно обратите внимание на поле.
*	помеченное как transient.
*	Обсудите почему это поле не было сохранено после десериализации
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData userData = new UserData("Dima", 31, "see");

        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(userData);
            System.out.println("Данные сериализованы");
        }

        try (FileInputStream fileInputStream = new FileInputStream("userdata.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            userData = (UserData)objectInputStream.readObject();
            System.out.println("Данные десериализованы");
        }

        System.out.println("Имя " + userData.getName());
        System.out.println("Возраст " + userData.getAge());
        System.out.println("Пароль " + userData.getPassword());

    }
}
