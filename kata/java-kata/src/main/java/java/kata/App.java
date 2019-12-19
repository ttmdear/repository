package java.kata;

import java.util.ArrayList;
import java.util.stream.Stream;

public class App
{
    public static void main(String[] args) {
        //String phone = createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

        ArrayList<Person> persons = new ArrayList<Person>(5);

        persons.add(new Person("Janek", 10));
        persons.add(new Person("Maciek", 20));
        persons.add(new Person("Godia", 25));
        persons.add(new Person("Krystian", 55));

        Stream<Person> personStream = persons.stream();

        System.out.println(personStream);
    }

    private static class Person implements Comparable<Person>{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int compareTo(Person person) {
            return getAge() > person.getAge() ? 1 : -1;
        }
    }

    // public static String createPhoneNumber(int[] numbers) {
    //     // Your code here!

    //     // (123) 456-7890
    //     return String.format("(%s%s%s) %s%s%s-%s%s%s%s",
    //         numbers[0],
    //         numbers[1],
    //         numbers[2],
    //         numbers[3],
    //         numbers[4],
    //         numbers[5],
    //         numbers[6],
    //         numbers[7],
    //         numbers[8],
    //         numbers[9]
    //     );
    // }
}


