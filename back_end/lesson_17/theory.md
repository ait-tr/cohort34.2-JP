# Logging
**Логирование** - это процесс записи информации о выполнении программы для последующего анализа.  
Как правило, запись осуществляется в файлы. Логи помогают разработчикам отслеживать работу приложения,
выявлять ошибки, идентифицировать узкие места и многое другое.

## Уровни логирования

OFF << FATAL << ERROR << WARN << INFO << DEBUG << TRACE
~~~  
 logging.level.root=INFO 
~~~

## Настройка логирования
~~~
logging.file.name=${spring.application.name}.log
~~~

## Пример
### org.apache.logging.log4j.Logger

~~~java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//// -------
private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

        logger.error("Error! Find user with {}",id);
        logger.warn("{} Warn!", id);
        logger.info("Info!");
        logger.debug("Debug!");
~~~

