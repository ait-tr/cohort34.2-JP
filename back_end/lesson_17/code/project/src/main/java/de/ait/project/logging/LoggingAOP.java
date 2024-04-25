package de.ait.project.logging;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAOP {
    private final Logger logger;

    @Pointcut("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOP(){}

    @Before("helloAOP()")
    public void hello(){
        logger.error("hello AOP");
    }

}
