
# One-to-many | Many-to-one

Наверное, самый распространенный тип связи *One-to-many | Many-to-one*: один клиент - много адресов, много позиций - один заказ, одна группа - много студентов и т.д.  
В нашем примере один Client, у него может быть много Card

**One-to-many** - один объект может быть связан с несколькими экземплярами других объектов.  
**Many-to-one** -  несколько экземпляров одной сущности могут быть связаны с одним экземпляром другой сущности. 

Очевидно что связи *One-to-many | Many-to-one* зеркально противоположны и зависят от направления описания.

Отношение  *One-to-many | Many-to-one* в Java может быть **unidirectional (однонаправленное)**
и **bidirectional (двунаправленное)**. В первом случае одна из сторон отношения не имеет информации о
связанном объекте\объектах. Например, объект клиент ничего не знает о связанных с ним объектах card.

В базе данных отношение OneToMany|ManyToOne не является двунаправленным. Оно реализовано с помощью внешнего ключа.  
С точки зрения БД таблица "Один" (Client) ничего не знает о таблице "Много" (Card). С другой стороны таблица "Много" Card
хранит внешний ключ - ссылку на "Один" (Client).

**Owner side (владеющая сторона)** - это сторона отношения, которой принадлежит внешний ключ в базе данных. Как правило,
в *Bidirectional OneToMany|ManyToOne отношение* это сущность "Много"(Card). Другую строну отношения, т.е. таблицу,
которая не хранит информацию о связи называют **Inverse side (обратная сторона)**. Как правило,
в *Bidirectional OneToMany|ManyToOne отношение* это сущность "Один"(Client)

### Реализация в Java
<img src="https://github.com/ait-tr/cohort34.2-JP/blob/main/back_end/lesson_14/pic/1.jpg">

### В классе "Много" (Card) @ManyToOne:

~~~java class Card
class Card {
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    @JsonBackReference
    private Client owner;
~~~

Создаем поле, типа *"Oдин"* (Client), над ним ставим аннотации:
1. **@ManyToOne**  - "много данных объектов связано с одним"
1. **@JoinColumn** - определяем колонку-внешний ключ. `name = "owner_id"` - колонка card.owner_id (таблица сущности "Много"), которая ссылается на id клиента (id сущности "Один")
1. **@JsonBackReference**

### В классе "Один" (Client) @OneToMany:

~~~java
class Client{
    @OneToMany (mappedBy = "owner", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)  
    @JsonManagedReference
    private List<Card> cards;
~~~

Создаем поле - коллекцию объектов типа *"Mного"* (Card), над ним ставим аннотации:
1. **@OneToMany**  - "один объект данного типа имеет много других объектов.   
   `mappedBy = "owner"` - определяем поле, в связанном классе "Много" (Card.owner), с которым ассоциирован класс "Один".
1. **@JsonManagedReference**

### В классе "Много" (Card): `@ManyToOne + @JoinColumn`  |   В классе "Один" (Client) : `@OneToMany (mappedBy)`  
