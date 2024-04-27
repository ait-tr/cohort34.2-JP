# Аспектно-ориентированное программирование (AOP)

**Аспектно-ориентированное программирование (AOP)** — это парадигма,
направленная на повышение модульности различных частей приложения за счет разделения *сквозных задач*.
Для этого к уже существующему коду добавляется дополнительного поведение, без изменений в изначальном коде.
*Аспектно-ориентированное программирование (AOP) помогает элегантно реализовать т.н. сквозные задачи приложения: логирование, мониторинг,
контроль доступа и т.п.

Ключевым элементом модульности в ООП является класс, тогда как в АОП это аспект.

<img src="https://www.javachinna.com/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2020/04/ccc-768x641.jpeg.webp">

Информацией о том, в каком сервисе применить тот или иной функционал, или не
применять его вовсе, не обладают ни сервисы, ни добавляемая функциональность.
Аспект "знает" какую и где функциональность подключить.

## Основные понятия

**Aspect** — модуль или класс, реализующий сквозную функциональность. Аспект изменяет
поведение остального кода, применяя Advice в Join-Point-ах, определенных некоторым
«срезом» (Pointcut).

**Pointcut (Срез)** — набор Join-Point.

**Join-Point (Точка соединения)** — точка в выполняемой программе, где следует применить Aspect.

**Advice (Совет)** — код, которой должно быть вызван из точки соединения.
Advice может быть выполнен до, после или вместо точки соединения.

**Внедрение (introduction)** — изменение структуры класса и/или изменение иерархии наследования для
добавления функциональности аспекта в инородный код.

Таким образом, Аспект, обладая информацией (получаемой от Advice ), разрывает выполнение
программного кода аспектируемых классов в точке соединения (join point) и внедряет туда известную ему
функциональность (программный код).

## Виды advice

1. **Before (Перед):**  `@Before`- выполняется перед методом
2. **After (После):** `@After` - выполняется перед методом
3. **After Returning(После возврата):** `@AfterReturning` - выполняется только в случае успешного завершения метода
4. **After Throwing (После бросания):** `@AfterThrowing` - выполняется только в случае Exception
5. **Around (Вокруг):** `@Around`  - выполняется до, после и ... вместо метода


## Подключение

~~~xml
<dependency>
    <groupId> org.springframework.boot </groupId>
    <artifactId> spring-boot-starter-aop </artifactId>
</dependency>
~~~
Spring Boot использует библиотеку *AspectJ*

## Создание простейшего аспекта

1. Создаем класс и помечаем его аннотациями `@Aspect` и `@Component`  
   Первая - говорит о том, что класс является аспектом, вторая - делает его бином.   
   Имя создаваемого класса не имеет значения

1. Создаем метод реализующий необходимый функционал, и помечаем его одной из следующих аннотаций:
    * `@Before`
    * `@After`
    * `@AfterReturning`
    * `@AfterThrowing`
    * `@Around`

1. В параметрах аннотации (параметр value) указываем *pointcut expression* - строка, которая определяет,
   в какие методы нашего приложения необходимо внедрить аспект


~~~java
    // ever method in service.UserServiceImpl log start event
    @Before("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOP(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("{} start ", methodName);
    }
~~~

## pointcut expression
~~~
 "execution(* de.ait.project.user.service.UserServiceImpl.*(..))"
~~~
В выражение можно использовать символы подстановки:
* \* - соответствует любой последовательности символов
* .. соответствует любому количеству параметров  

### Примеры:

1. `"execution(* de.ait.project.user.service.UserServiceImpl.findAll())"`  
   Метод, UserServiceImpl.findAll()

1. `execution(* find*(..))`  
   Любой метод, имя которого начинается с «find».

1. `"execution(* de.ait.project.user.service.UserServiceImpl.*(..))"`  
   Любой метод, в классе «UserServiceImpl».

1. `"execution(* de.ait.project.user.service.UserServiceImpl.*(int,String))"`  
   Любой метод, в классе «UserServiceImpl» с параметрами *(int .. , String ..)*

1. `"execution(* de.ait.project.user.service.*.*(..))"`  
   Любой метод, в пакедже *de.ait.project.user.service*

1. `"@annotation(de.ait.project.logging.Profiler)"`  
   Любой метод, помеченный аннотацией Profiler

### Пример
Подключаем логирование во все методы класса UserServiceImpl  

~~~java
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAOP {
    private final Logger logger;

    @AfterReturning(value = "execution(* de.ait.project.user.service.UserServiceImpl.*(..))", returning = "result")
    public void loggingArgumentsAOP(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.toShortString();  // получили имя метода


        Object[] args = joinPoint.getArgs(); // получили аргументы
        String argsString = "[ void ]";
        if (args.length > 0) {                  // если аргументы есть собираем строку из аргументов
            argsString = Arrays.asList(args).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(";", "[", "]"));
        }

        logger.error("Method name:{} arguments:{} finished {}", name, argsString, result);
    }
}
~~~