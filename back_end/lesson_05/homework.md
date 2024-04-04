
# Задача 1
* создать новый проект используя https://start.spring.io/
* создайте класс Client (Long id, String name, String email )
* создайте ClientController, по примеру кода занятия реализуйте Get Mapping, который должен по запросу localhost:8080\client возвращать фиксированного клиента

# Задача 2
* создайте класс Account (Long id, String iban, double balance, Client owner)
* создайте List<Account> 
* создайте AccountController, реализуйте Get Mapping, который должен по запросу localhost:8080\accounts возвращать список счетов

# Задача 3
* реализуйте get mapping localhost:8080\clients который возвращает всех клиентов банка (т.е. всех owner из списка счетов)
* вспомните о многослойной организации приложения и разбейте реализованный функционал по слоям