package Homeworks.Lesson4;


import javax.persistence.*;
import java.util.Random;
@Entity
@Table(name="persons")
public class Person {

    private static final Random random = new Random();
    private static final String[] names = new String[]{"Анатолий", "Владислав", "Владимир", "Дмитрий", "Александр", "Евгений", "Петр", "Марат", "Рома", "Артур", "Данил", "Сергей", "Василий"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public void updateAge(){
        age = random.nextInt(26);
    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Person create(){
        return new Person(names[random.nextInt(names.length)], random.nextInt(20));
    }
}
