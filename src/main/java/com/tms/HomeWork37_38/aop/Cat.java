package com.tms.HomeWork37_38.aop;

import com.tms.HomeWork37_38.annotations.MyAspectAnnotation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component(value = "cat")
public class Cat {

    @MyAspectAnnotation
    public void catVoice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Meow meow...");
    }

    public boolean isCatHungry(boolean eat) {
        if (eat) {
            System.out.println("The cat meows and asks for food!");
        } else {
            System.out.println("The cat is sleeping...");
        }
        return eat;
    }
}
