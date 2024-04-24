## Много ко многим (Many-to-Many  )

### Описание примера
Есть две сущности: **Клиенты** и **Карты**.  
Клиент может иметь много карт, каждая карта может принадлежать нескольким клиентам.

~~~sql
create table card(
    card_id bigint auto_increment primary key,
    number  varchar(255) null,
    type    varchar(255) null
);

create table client(
    client_id bigint auto_increment primary key,
    name      varchar(255) null
);

create table client_card(
    client_id bigint not null,
    card_id   bigint not null,
    foreign key (card_id) references card (card_id),
    foreign key (client_id) references client (client_id),
    unique (card_id, client_id)
);


~~~


### В классе Client:

~~~java 

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
@JoinTable( name = "client_card",
        joinColumns = { @JoinColumn(name = "client_id") },    
        inverseJoinColumns = { @JoinColumn(name = "card_id") },
        uniqueConstraints = @UniqueConstraint(columnNames = {"card_id", "client_id"}))

private List<Card> cards;
~~~

### В классе Card:

~~~java
@ManyToMany(fetch = FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE}, 
            mappedBy = "cards")
    
List<Client> owners;
~~~



# Валидация
**Валидация** (en. *validate*) - это механизм проверки данных объекта на корректность перед их сохранением в базу данных.

* **@NotNull**: поле не должно быть нулевым.
* **@NotEmpty**: поле-коллекция не должно быть пустым.
* **@NotBlank**: поле-String не должно быть пустой строкой (т. е. оно должно
  содержать хотя бы один символ).
* **@Min** и **@Max**: числовое поле допустимо только тогда, когда его значение выше
  или ниже определенного значения.
* **@Pattern**: поле-String должно соответствовать определенному регулярному выражению.
* **@Email**: строковое поле должно быть действительным адресом электронной почты.
---
* **@Valid** : аннотация запускающая проверку


----
### Подключение валидации
~~~java
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
			<version>3.1.3</version>
		</dependency>
~~~
Аннотации валидации ставятся в классе request Dto сущности или в самой сущности над полем.  
В контроллере параметр метода-обработчика Post помечаем аннотацией `@Valid`

# ResponseEntity<>
ResponseEntity - удобная "обертка" для HTTP-ответ, которая позволяет передать не только тело ответа, 
но и другие параметры, такие как статус код, заголовки и т.д. 
Он используется для создания ответов контроллеров в Spring MVC.
~~~java
public ResponseEntity<UserResponseDto> createNewUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.save(userRequestDto),HttpStatus.CREATED) ;
    }
~~~

# Exception Handling
## Обработка exception в контроллере
1. Создаем объект ApiError - объект, в котором мы возвращаем информацию о причинах внештатной ситуации для клиента.
1. В контроллере создаем метод-обработчик:
   * Метод необходимо пометить аннотацией @ExceptionHandler
   * В параметре аннотации указываем класс обрабатываемого Exception
   ~~~java
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiError> handleException(FirstTestException e) {
            return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
   ~~~
Такой способ подходить для обработки специфичных для данного контроллера Exception

## Аннотация @ResponseStatus над exception

1. Создаем Exception
1. Ставим над Exception аннотацию `@ResponseStatus`

~~~java
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
public class ClientNotFoundException extends RuntimeException {
    public SecondTestException(String message) {
        super(message);
    }
~~~

Все, нам не надо писать свой обработчик. Такой способ подходить для того, что б глобально обработать exception
заданного типа.  
Минус: нет возможности кастомизировать обработку.
Все исключения типа ClientException будут генерировать в ответе одно и то же сообщение об ошибке и код состояния.

## Создание ControllerAdvice класса
Spring позволяет создать класс, в котором собрать все обработчики Exception:
1. Создаем класс
1. Помечаем его аннотацией `@ControllerAdvice`
1. В нем размещаем методы-обработчики, используя аннотацию  @ExceptionHandler(Exception.class)

~~~java
@ControllerAdvice
public class AdviceController {
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
    public class ClientNotFoundException extends RuntimeException {
        public SecondTestException(String message) {
            super(message);
        }
    }
~~~