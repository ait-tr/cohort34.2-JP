package de.ait;

public class Main {
    public static void main(String[] args) {
        //Person person = new Person("Jack", "Johnson",20);
        //Person person1 = new Person();

        Person person = Person.of("Jack", "Johnson",20);
        System.out.println(person);

        Person person2 = Person.builder()
                .age(20)
                .fName("John")
                .build();
        System.out.println(person2);

    }
}