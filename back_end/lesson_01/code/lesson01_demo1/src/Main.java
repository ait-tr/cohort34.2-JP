import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> userList = new ArrayList<>();
        long counter=0;

        while (true) {
            System.out.print("Введите имя : ");
            String name = scanner.nextLine();
            System.out.print("Введите email : ");
            String email = scanner.nextLine();


            if (name.isEmpty() || !email.contains("@")) {
                System.out.println("Некорректные данные. Повторите ввод.");
                return;
            }
            userList.add(new User(++counter,name, email));

            System.out.print("Добавить еще одного пользователя? (yes/no): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Список пользователей:");
        for (User user : userList) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail());
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt"))) {
            for (User user : userList) {
                writer.println(user.getName()+ ";" + user.getEmail());
            }
            System.out.println("Пользователи сохранены в файл users.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл.");
            e.printStackTrace();
        }
    }
}