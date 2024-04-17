
# JDBC
**JDBC (Java Database Connectivity)** - стандартный API для взаимодействия Java программы с различными базами данных
 

<img src="pic\jdbc.jpg"/>

* JDBC API позволяет реализовать взаимодействие с любой реляционной базой данных, вне зависимости от специфики, используя стандартное API.
* Драйвер (Oracle JDBC Driver, MySql Jdbc Driver и т.д.) или, как еще говорят, "коннектор" реализует взаимодействие учитывая особкнности конкретной базы. Как правило, драйвер поставляется поставщиком БД.
* Driver Manager - обеспечивает связь между абстрактным слоем JDBC API и драйвером конкретной СУБД 

### Подключение БД MySql (без спринг)

    ~~~xml
    <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>
    ~~~

Для осуществления взаимодействия по JDBC необходимо:
1. Создать Connection к БД
2. На основе Connection создать Statement
3. На основе Statement выполнить SQL запрос и получить ResultSet
4. Обработать ResultSet получив набор Java объектов

## 1. Создать Connection к БД
~~~Java
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = getConnection("jdbc:mysql://localhost:3306/user_app/?user=sa&password=123");
        } catch (SQLException e) {} 
~~~

## 2. На основе Connection создать Statement

~~~Java
       Statement statement = connection.createStatement();
~~~

## 3. На основе Statement выполнить SQL запрос и получить ResultSet

~~~Java
       ResultSet resultSet = statement.executeQuery("SELECT * FROM t_user");
~~~

## 4. Обработать ResultSet получив набор Java объектов

~~~Java
       while (resultSet.next()){
            //long id = resultSet.getLong(1); // обрацение по номеру колонки
            long id = resultSet.getLong(ID);  // обрацение по имени колонки (предпочтительно)
            String name = resultSet.getString(NAME);
            String email = resultSet.getString(EMAIL);
                            ........
            User user = new User(id, name, password,email, age );
            users.add(user);
        }
            return users;
~~~
