package Seminars.Lesson3.task2;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Seminars.Lesson3.task2.ToDoListApp.*;

public class Program {
    public static void main(String[] args) {
        List<ToDo> tasks;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            tasks = loadTasksFromFile(FILE_JSON);
        else
            tasks = prepareTasks();
        ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
        ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
        ToDoListApp.saveTasksToFile(FILE_XML, tasks);


        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Отметить задачу как выполненую");
            System.out.println("3. Выйти");

            switch (scanner.nextLine()){
                case "1":
                    addNewTask(scanner, tasks);
                    break;
                case "2":
                    markTaskAsDone(scanner, tasks);
                    break;
                case "3":
                    saveTasksToFile(FILE_JSON,tasks);
                    saveTasksToFile(FILE_BIN,tasks);
                    saveTasksToFile(FILE_XML,tasks);
                    break;
            }
            displayTasks(tasks);


        }


    }

    static List<ToDo> prepareTasks(){

        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Сходить в магазин"));
        list.add(new ToDo("Погулять с собакой"));
        list.add(new ToDo("Заменить лампочку"));
        return list;
    }
}
