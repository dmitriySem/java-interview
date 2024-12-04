package macro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Lesson1_LamdaStreamApi {

    public static void main(String[] args) {
	// write your code here

        /*
        Напишите программу, которая использует Stream API для обработки списка чисел.
        Программа должна вывести на экран среднее значение всех четных чисел в списке.
         */

        List<Double> numbers = new ArrayList<>();

        numbers.add(1.0);
        numbers.add(2.1);
        numbers.add(4.0);
        numbers.add(5.0);
        numbers.add(8.0);
        numbers.add(48.0);

        System.out.println();
        OptionalDouble average = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList()).stream().mapToDouble(value -> value).average();
        System.out.println(average.getAsDouble());


    }
}
