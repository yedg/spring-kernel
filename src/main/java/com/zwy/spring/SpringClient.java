package com.zwy.spring;

import com.zwy.beans.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClient {
    public static void main(String[] args) {
        Resource resource=new ClassPathResource("application.xml");

        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);
        Student student = (Student)defaultListableBeanFactory.getBean("student");

        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
