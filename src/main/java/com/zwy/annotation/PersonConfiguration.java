package com.zwy.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {
    @Bean(name = "person")
    public Person getPerson() {
        Person person = new Person();
        person.setId(123);
        person.setName("zwy");
        return person;
    }
}
