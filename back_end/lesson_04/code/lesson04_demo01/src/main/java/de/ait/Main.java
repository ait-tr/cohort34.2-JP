package de.ait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Person person =new Person("Jack",20);

        String jsonString = mapper.writeValueAsString(person);
        System.out.println(jsonString);

        mapper.writeValue(new File("person.json"),person );


    }
}