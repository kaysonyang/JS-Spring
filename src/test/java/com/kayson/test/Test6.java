package com.kayson.test;

import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kayson.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kayson.springframework.context.support.ClassPathXmlApplicationContext;
import com.kayson.test.bean.ProductService;
import com.kayson.test.bean.UserService;
import com.kayson.test.common.MyBeanFactoryPostProcessor;
import com.kayson.test.common.MyBeanPostProcessor;
import org.junit.Test;

public class Test6 {


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
