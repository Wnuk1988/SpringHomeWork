package com.tms;

import com.tms.HomeWork37_38.aop.Cat;
import com.tms.HomeWork37_38.aop.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.tms")
public class ProgramStart {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");
//        Cat cat = context.getBean("cat", Cat.class);
//        Dog dog = context.getBean("dog", Dog.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(ProgramStart.class);
        Cat cat = context.getBean("cat", Cat.class);
        cat.catVoice();
        cat.isCatHungry(true);
        Dog dog = context.getBean("dog", Dog.class);
        dog.dogVoice();
        dog.dogWalk(5);
//        @Bean(value = "cat")
//        public static Cat catBean () {
//            return new Cat();
//        }
    }
}
