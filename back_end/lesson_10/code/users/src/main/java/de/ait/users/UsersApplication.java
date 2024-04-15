package de.ait.users;
/*
Создать новый проект.
В качестве сущьности есть сделать класс User(Long id, String name, String password, String email, int age)
Реализовать следующие эндпоинты:
GET  /users
GET  /users/{userID}

 */

import de.ait.users.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		// получить контекст
		ConfigurableApplicationContext context = SpringApplication.run(UsersApplication.class, args);

		// получить бин из контекста
		UserController controller = context.getBean(UserController.class);
		//System.out.println(controller.getAllUsers(0,"klod"));

	}

}
