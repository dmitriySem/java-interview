package Seminars.Lesson4.task2;


import Seminars.Lesson4.task2.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(Student.class).
                    buildSessionFactory()){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //Создание объекта
            Student student = Student.create();
            session.save(student);
            System.out.println("Object student save successfully");


            //Чтение объекта из базы данных
            Student retriStudent = session.get(Student.class, student.getId());
            System.out.println("Object student rerived successfully");
            System.out.println("Retrieved student object: " + retriStudent);

            //Обновление объекта
//            retriStudent.updateName();
            retriStudent.updateAge();
            session.update(retriStudent);
            System.out.println("Object student update successfully");

            //Чтение объекта из базы данных
            retriStudent = session.get(Student.class, student.getId());
            System.out.println("Object student rerived successfully");
            System.out.println("Retrieved student object: " + retriStudent);


            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }




    }
}
