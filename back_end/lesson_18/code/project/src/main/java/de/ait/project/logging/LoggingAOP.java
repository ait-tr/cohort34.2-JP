package de.ait.project.logging;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAOP {
    private final Logger logger;

/*
    @Pointcut("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOP(){}

    @Before("helloAOP()")
    public void hello(){
        logger.error("hello AOP");
    }
*/


    @Before("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOPBefore(){
        logger.error("hello AOP Before");
    }


    @After("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOPAfter(){
        logger.error("hello AOP After");
    }

    @AfterReturning("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOPAfterReturning(){
        logger.error("hello AOP AfterReturning");
    }

    @AfterThrowing("execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public void helloAOPAfterThrowing(){
        logger.error("hello AOP AfterThrowing");
    }

    @AfterReturning(value = "execution(* de.ait.project.user.service.UserServiceImpl.*(..))", returning = "result")
    public void loggingArgumentsAOP(JoinPoint joinPoint, Object result){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.toShortString();  // получили имя метода


        Object[] args = joinPoint.getArgs(); // получили аргументы
        String argsString ="[ void ]";
        if(args.length>0){                  // если аргументы есть собираем строку из аргументов
            argsString =Arrays.asList(args).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(";","[","]"));
        }

        logger.error("Method name:{} arguments:{} finished {}",name, argsString, result);
    }

    // all methods start with 'find...'
    //@Before("execution( de.ait.project.user.service.*.*(..))")
    //@Before("execution(* de.ait.project.user.service.UserServiceImpl.find*(int,String))")
    @Before("execution(* de.ait.project.user.service.UserServiceImpl.find*(..))")
    public void helloAOPBefore1(){
        logger.error("hello AOP Before 11");
    }

    @SneakyThrows
    @Around(value = "@annotation(de.ait.project.logging.Profiler)")
    //@Around(value = "execution(* de.ait.project.user.service.UserServiceImpl.*(..))")
    public Object profiler(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        methodName = proceedingJoinPoint.getSignature().toShortString();
        //logger.debug("start {}", methodName);
        logger.error("PROFILER: start {}", methodName); //!!!
        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long finish = System.currentTimeMillis();
        logger.error("PROFILER: finish {} time: {} ms ",methodName,finish-start);

        return result;
    }



}
