package de.ait;

import de.ait.model.User;
import de.ait.repositories.FileUserRepositoryImpl;
import de.ait.repositories.UserCrudRepository;
import de.ait.service.UserService;
import de.ait.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //UserCrudRepository repository = new ListUserRepositoryImp();
        UserCrudRepository repository = new FileUserRepositoryImpl("1.txt");
        UserService service = new UserServiceImpl(repository);
        Scanner scanner = new Scanner(System.in);

        User u1 = User.builder()
                .email("qwer@mail.ru")
                .name("qwer")
                .build();

        /*
        repository.save(new User(1L,"2", "retyu"));

        List<User> all = repository.findAll();
        System.out.println(all);
        all.add(new User(2L,"3","qwerty"));


        List<User> all1 = repository.findAll();
        System.out.println("all: " + all);
        System.out.println("all1: " + all1);

         */






        while (true) {
            System.out.print("Введите имя : ");
            String name = scanner.nextLine();
            System.out.print("Введите email : ");
            String email = scanner.nextLine();



            service.addUser(new User(name,email));

            System.out.print("Добавить еще одного пользователя? (yes/no): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Список пользователей: ");
        System.out.println(service.getAllUsers());
    }
}