package de.ait.lesson06_dz;
/*
# Задача 1
В проекте сделанном на занятии:
* сделать эндпойнт вида /accounts/1 ,который возвращает счет с заданным id
* предположим, одному клиенту принадлежит несколько счетов. Необходимо реализовать
  эндпойнт вида /clients/1/accounts , который возвращает все сета, заданного клиента



# Задача 2
Добавть в проект сущьность Transaction {Long id, Account debit, Account credit, double amount)
(Репозиторий для транзакций сделать в виде List или Map<Long,Transaction> т.е. id,транзакция)
Реализовать следующие эндпоинты:
* GET /transactions  - все транзакции
* GET /transactions/1  - транзакция c заданным id
* GET /accounts/1/transactions  - все транзакции в которых участвует счет с заданным id

 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson06DzApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lesson06DzApplication.class, args);
		System.out.println("hello");
	}

}
