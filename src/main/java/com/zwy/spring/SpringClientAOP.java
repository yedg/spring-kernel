package com.zwy.spring;

import com.zwy.aop.service.MyService;
import com.zwy.beans.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClientAOP {
    public static void main(String[] args) {
        Resource resource=new ClassPathResource("application2.xml");

        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);
        MyService myService = (MyService)defaultListableBeanFactory.getBean("myAOP");

        myService.myMethod();

        System.out.println(myService.getClass());
        System.out.println(myService.getClass().getSuperclass());
        System.out.println(myService.getClass().getInterfaces().length);
        Class<?>[] interfaces = myService.getClass().getInterfaces();
        for(int i=0;i<interfaces.length;i++){
            System.out.println(interfaces[i]);
        }
    }
}
