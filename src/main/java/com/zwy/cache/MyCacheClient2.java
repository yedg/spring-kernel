package com.zwy.cache;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MyCacheClient2 {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("application4.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(classPathResource);

        AccountService service = (AccountService)defaultListableBeanFactory.getBean("myAOP");
        long start=System.currentTimeMillis();
        service.getAccountByName("zwy");
        long end1=System.currentTimeMillis();
        service.getAccountByName("zwy");
        long end2=System.currentTimeMillis();
        System.out.println("第一次查询耗时:"+(end1-start));
        System.out.println("第二次查询耗时:"+(end2-end1));
    }
}
