package com.nowcoder.AspectJDemo;

import org.springframework.stereotype.Component;

@Component(value = "example")
public class Example implements IExample{
    @Tag
    public void say(){
        System.out.println("helloworld");
    }

}
