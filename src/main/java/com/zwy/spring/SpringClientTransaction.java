package com.zwy.spring;

import com.zwy.aop.service.MyService;
import com.zwy.beans.Student;
import com.zwy.service.StudentService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClientTransaction {
    public static void main(String[] args) {
        Resource resource=new ClassPathResource("application3.xml");

        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);
        StudentService studentService = (StudentService)defaultListableBeanFactory.getBean("studentServiceProxy");

        Student student = new Student();
        student.setName("zwy");
        student.setAge(25);

        studentService.saveStudent(student);
    }
}
