package com.zwy.spring;

import com.zwy.annotation.Person;
import com.zwy.annotation.PersonConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解与基于XML配置的 Spring Bean在创建时机上存在唯一的不同之处:
 * 1.基于XML配置的方式,Bean对象的创建是在程序首次从工厂中获取该对象时才创建的。
 * 2.基于注解配置的方式,Bean对象的创建是在注解处理器解析相应的Bean注解时调用了该注解所修饰的方法,
 * 当该方法执行后,相应的对象自然就已经被创建出来了,这时, Spring就会将该对象纳入到工厂的管理范围之内,
 * 当我们首次尝试从工厂中获取到该Bean对象时,这时,该Bean对象实际上已经完成了创建并已被纳入到了工厂的管理范围之内
 */
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
