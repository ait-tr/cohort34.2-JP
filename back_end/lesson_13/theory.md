
# Spring Data Jpa

**ORM (Object-Relational Mapping)** или *объектно-реляционное отображение* - технология, которая помогает работать с реляционными базами данных используя *OPP*, вместо языка запросов
(SQL). ORM позволяет:
* связать объектно-ориентированный язык программирования (например, Java) и базу данных
* взаимодействовать с базой данных используя привычные классы, объекты, методы вместо SQL


**JPA (Java Persistence API)** это стандартная спецификация Jakarta Java (Java EE) 
регламентирующая реализацию ORM в Java. JPA не является реализацией ORM, JPA - спецификация. JPA отвечает на вопрос, как должен быть реализован ORM в Java. 
JPA определяет интерфейсы и аннотации, которые разработчики могут использовать для 
описания отображения объектов на таблицы баз данных и выполнения операций *CRUD (Create, Read, Update, Delete)*
над этими объектами.   

Обычно для реализации слоя доступа к данным (Data Access Layer) в Java приложениях 
используется  Hibernate.  

**Hibernate** одна из самых популярных реализаций JPA в мире Java. Hibernate предоставляет 
набор инструментов для отображения объектов Java на таблицы базы данных и наоборот. 
Некоторые возможности: 
* кэширование данных
* управление транзакциями
* запросы на языке HQL (Hibernate Query Language)  


**Spring Data Jpa** - Spring Data JPA - это часть Spring Framework, которая реализует JPA в Spring, плюс предоставляет 
дополнительные удобства для работы с базами данных, такие как:
* автоматическая генерация запросов на основе имен методов репозитория
* поддержка пагинации и сортировки результатов
* возможность определения пользовательских методов запросов с использованием аннотаций и др.

Можно сформулировать следующую иерархию:

<img src="https://miro.medium.com/v2/resize:fit:1400/1*JIMqf99Z0x5tLqHs03QDdQ.png">


## Подключение spring-data-jpa к проекту

~~~xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
~~~

т.к. в основе лежит JDBC, не забываем драйвер БД:

~~~xml
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
~~~

Некоторые настройки: в `application.property` прописываем настройки для подключения базы данных (в нашем случае MySQL):
   ~~~properties
    # подключение к БД (драйвер, URL базы, имя пользователя, пароль)
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/[база данных] 
    spring.datasource.username=[имя]
    spring.datasource.password=[пароль]
    
    # стратегия создания таблиц
    spring.jpa.hibernate.ddl-auto=create-drop 
    
    #логирование SQL запросов
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true 
   ~~~

----
## Пример создания CRUD приложения

1. Создаем новый проект, включаем в него зависимости:
    * Spring Web
    * Spring Data JPA
    * MySql Driver
    * Lombok
   
1. Добавляем [Swagger](https://springdoc.org/).  
   Зависимость:
   ~~~xml
           <dependency>
               <groupId>org.springdoc</groupId>
               <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
               <version>2.5.0</version>
           </dependency>
   ~~~
   [опционально] В `application.property` можем указать прописываем настройку `springdoc.swagger-ui.path=/swagger`
   По умолчанию swagger имеет адрес: http://localhost:8080/swagger-ui/index.html

1. Создаем базу данных:
   ~~~sql
   create database ad_project;
   ~~~  
   
1. В `application.property` прописываем настройки для подключения базы данных (cм. выше "Подключение spring-data-jpa к проекту")
1. Создаем структуру пакетов:
    * de.ait.project.advertisement
        * model
        * dto
        * repository
        * service
        * controller
1. Создаем класс-сушьность: model.Advertisement
   Для репозитория необходимо
    * у класса указать следующие аннотации:   
      `@Entity`  
      `@Table(name="advertisement")`
    * над полем _id_ указать аннотации:  
      `@Id`  
      `@GeneratedValue(strategy = GenerationType.IDENTITY)`
    * над всеми полями указать аннотацию  
      `@Column(name = "id")`  

1. В пакете repository создаем интерфейс `AdvertisementRepository`:
   ~~~java
   public interface AdvertisementRepository
        extends JpaRepository< Advertisement, Long > {
    }
   ~~~
   Важно: интерфейс должен расширять интерфейс `JpaRepository< T, ID >`  
   `T` - тип сущности, `ID` - тип поля-идентификатора  

    **Обратите внимание: вам не нужно реализовывать ваш интерфейс, 
    т.к. реализация будет предоставлена Spring Boot**  
    При этом у вас автоматически будут доступны стандартные методы: findAll(), findById(), save() и др.
    
1. Создаем интерфейс `AdvertisementService` и его имплементацию.
   В сервис необходимо внедрить зависимость на репозиторий   
   ~~~java
    @Service
    @RequiredArgsConstructor
    public class AdvertisementServiceImpl implements AdvertisementService{
      private final AdvertisementRepository repository;
    
      public List<AdvertisementDto> findAll() {
        return repository.findAll();
     }
    }
   ~~~ 
1. Реализуйте DTO-классы  
   **Правило: взаимодействие с клиентской частью приложение всегда осуществляет через DTO классы! 
   Controller не должен знать про entity классы!**  
1. Реализуйте контроллер.  
   В контроллер необходимо внедрить зависимость на сервис


