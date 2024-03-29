package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Deque<String> q = new LinkedList<>();
        User user = new User("qwe", 10);
        Set<User> set  = new HashSet<>();

        set.add(user);
        user.age = 11;
        System.out.println(set);

        User user2 = new User("qwe", 11);
        set.add(user2);
        System.out.println(set);



    }
}