package Homeworks.Lesson4;

import Homeworks.Lesson4.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.Random;

public class Program {

    /*
    Задание: Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
    Создайте несколько объектов Person и сохраните их в базу данных.
     */
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().
                configure(new File("D:\\Geekbrains_homeworks\\java-spora\\java-interview\\JavaJunior\\Lesson1_Lambda_StreamApi\\src\\main\\java\\Homeworks\\Lesson4\\resources\\hibernate.cfg.xml")).
                addAnnotatedClass(Homeworks.Lesson4.Person.class).
                buildSessionFactory()){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //Создание объекта
            Random random = new Random();

            for (int i=0; i<random.nextInt(100); i++){
               Person person = Person.create();
               session.save(person);
            }
            System.out.println("Object student save successfully");


            //Чтение объекта из базы данных
//            Person retriStudent = session.get(Person.class, person.getId());
//            System.out.println("Object student rerived successfully");
//            System.out.println("Retrieved student object: " + retriStudent);

            //Обновление объекта
//            retriStudent.updateName();
//            retriStudent.updateAge();
//            session.update(retriStudent);
//            System.out.println("Object student update successfully");

            //Чтение объекта из базы данных
//            retriStudent = session.get(Person.class, person.getId());
//            System.out.println("Object student rerived successfully");
//            System.out.println("Retrieved student object: " + retriStudent);


            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
