package de.ait.users;
/*
Реализовать в проекте User класс Address {Long id, String country, String zipCode, String city, String
street, String house } Пока этот класс ни как не связан с User! Реализовать обработку следующих endpoint-ов

GET \addresses - вывести все адреса
GET \addresses\id - вывести адресс с заданным id
GET \addresses?country=usa - вывести все адресса в заданной стране (в нащем примере usa)
GET \addresses?city=berlin - вывести все адресса в заданном городе (в нащем примере berlin)
GET \addresses?city=berlin&&street=potsda - вывести все адресса в заданном городе на улицах, которые содержат заданную подстроку
POST\address - создать новый адресс
DELETE\address\id - удалить адрес
PUT\address\id - изменить адрес
Используйте DTO

Задача 2
Создавая новый address клиент не должен вводить Id (подсказка: используйте DTO)

Настроит swagger
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
