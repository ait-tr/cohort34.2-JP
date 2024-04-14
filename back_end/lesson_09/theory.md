
# Swagger
Swagger — это набор инструментов, который позволяет автоматически описывать API на основе его кода.  

Для подключения к Spring-проекту необходимо указать зависимость:
~~~xml
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>
~~~

Запустив сервер, переходим по адрессу
~~~consol
http://localhost:8080/swagger-ui/
~~~
Страница Swagger генерируеться автоматически, на основе кода, но ее можно настраивать с помощью аннотаций:
Например, поля DTO-объектов могут быть "прокомментированы" следующим обраъом:
~~~java
    @Schema(description = "id пользователя", example = "234")
    private Long id;
    @Schema(description = "имя пользователя", example = "andy")
    private String name;
    @Schema(description = "email пользователя", example = "andy@mail.com")
    private String email;
    @Schema(description = "возраст пользователя", example = "43")
    private int age;
~~~
а, например метод в контроллере так:
~~~java
    @Operation( summary = "Получение списка пользователей",
                description = "Список всех пользоваьелей. Доступно администратору")
~~~

# @RequestParam
Аннотация @RequestParam помогает извлеч парраметры HTTP запроса и организовать в Controller-е обработку URI вида
~~~console
localhost:8080/users?age=20&&name=jack
~~~
Аннотация ставиться на парраметр метода-обоаботчика:
~~~java
@GetMapping
    public List<UserRequestDTO> getAllUsers(@RequestParam(required = false, defaultValue = "0") int age,
                                            @RequestParam(required = false) String name){
~~~
required = false - необязательный параметр  
defaultValue = "0" - значение, если параметр отсутствует  
Данная аннотация регламентирует Controller-у параметр метода заполнить значением из соответствующего
праметра запроса. Естественно, логика вашего метода должно обрабатывать эти парраметры.

# @Bean
На основе любого класса Spring может создать бин (en. bean), т.е. создать объект, поместить этот объект в Application Context, 
внедрять его и использовать по мере необходимости в других классах приложения. Для этого класс должен быть помечен аннотацией @Component, или любой из производных аннотаций: @Controller, @Service, @Repository и т.д. 
Но что если класс не наш, он уже написан и мы не можем в нем поставить необходимые аннотации?  

Возмем например класс Scanner. У нас нет возможности внутри указать аннотацию @Component. Как можно сделать бин на основе класса @Scanner?  
1. Создаем любой класс и помечаем его аннотацией @Configuration
2. В этом классе описываем метод, который создает и возвращает  Scanner
3. Помечаем этот метод аннотацией @Bean  

~~~Java
@Configuration
public class AppConfiguration {
 
    @Bean
    public Scanner getScanner(){
        return new Scanner(System.in);
    }
}
~~~


# DTO
** DTO (Data Transfer Object) **  
<img src="pic\User.png"/>