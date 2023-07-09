package com.tms.HomeWork37_38.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class AspectProgram {
    @Before(value = "within(com.tms.HomeWork37_38.aop.*)")
    public void startTimeProgram(JoinPoint joinPoint) {
        System.out.println(LocalTime.now() + " " + joinPoint.getSignature().getName() + " start method working...");
    }

    @After(value = "within(com.tms.HomeWork37_38.aop.*)")
    public void finishedTimeProgram(JoinPoint joinPoint) {
        System.out.println(LocalTime.now() + " " + joinPoint.getSignature().getName() + " finished method work!");
    }

    @Around(value = "execution(public * com.tms.HomeWork37_38.aop.Cat.*())")
    public Object timeWorkingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Method started " + joinPoint.getSignature().getName());
        LocalTime startTime = LocalTime.now();
        Object timeWorking = joinPoint.proceed();
        LocalTime finishedTime = LocalTime.now();
        System.out.println("Time working the method: " + (finishedTime.getNano() - startTime.getNano()));
        System.out.println("Method finished " + joinPoint.getSignature().getName());
        return timeWorking;
    }

    @AfterThrowing(value = "execution(public * com.tms.HomeWork37_38.aop.Dog.dogWalk())", throwing = "throwable")
    public void printThrowing(Throwable throwable) {
        System.out.println(throwable);

    }

    @AfterReturning(value = "within(com.tms.HomeWork37_38.aop.*)", returning = "information")
    public void information(Object information) {
        System.out.println("Returned information from aspect: " + information);
    }
//    @After(value = "@annotation(com.tms.HomeWork38.annotations.MyAspectAnnotation)")
//    public void finishedTimeProgram(JoinPoint joinPoint) {
//        System.out.println(LocalTime.now() + " " + joinPoint.getSignature().getName() + " finished method work!");
//    }
}
