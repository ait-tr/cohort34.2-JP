# Задача 1
Осознать код, написанный на занятии, особенно ту часть, что касается JdbcTemplate 

# Задача 2

Давайте создадим новый проект, например "advertisement".  
Какие зависимости надо добавить в проект? Не забудьте Spring Data JPA и MySql Driver.
В проекте создайте сущность Advertisement{Long id, String category, String title, String description, String authorName}  
Вам необходимо реализовать приложение, которое позволит:
* добавить объявление,
* найти объявление по id
* вывести все объявления в заданной категории
* изменить объявление
* удалить объявление

Используйте JPARepository
