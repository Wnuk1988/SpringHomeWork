package com.tms.HomeWork37_38.aop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component
public class Dog {
    public void dogVoice() {
        System.out.println("Woof woof...");
    }

    public Integer dogWalk(int hour) {
        if (hour < 3) {
            System.out.println("The dog walked for a short time...");
        } else if (4 <= hour && hour <= 8) {
            System.out.println("The dog is out.");
        } else {
            throw new ArithmeticException();
        }
        return hour;
    }
}
