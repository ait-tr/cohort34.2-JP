## Lombok

Lombok - библиотека, которая позволяет сократить написание шаблонного кода (англ. boilerplate code) т.е. конструкторов, геттеров, сеттеров и т.д. Страница проекта: https://projectlombok.org/  

Подключение:
 * добавить зависимость в pom.xml
 * в Idea установить плагин
 * в настройках в Idea включить настройку 
*Enable annotation processing*

Основные аннотации:

* **@AllArgsConstructor**  - генерирует конструктор со всеми аргументами
* **@RequiredArgsConstructor** - генерирует конструктор с необходимыми  аргументами т.е. все  final поля и @NotNull поля ,  
* **@NoArgsConstructor** - генерирует конструктор без аргументов.
* **@Getter** - генерирует стандартного вида геттер
* **@Setter** - генерирует стандартного вида сеттер
* **@ToString** - генерирует toString()
* **@EqualsAndHashCode** - генерирует equals() и hashCode();
* **@Builder** - генерирует паттерн Builder;
 
