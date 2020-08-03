package com.zwy.spring;

import com.zwy.annotation.Person;
import com.zwy.annotation.PersonConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(PersonConfiguration.class);
        annotationConfigApplicationContext.refresh();
        Person person =(Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person.getId());
        System.out.println(person.getName());
    }
}
