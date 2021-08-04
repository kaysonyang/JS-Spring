package com.kayson.test;

import com.kayson.test.bean.ProductService;
import com.kayson.test.bean.UserService;
import com.kayson.test.common.MyBeanFactoryPostProcessor;
import com.kayson.test.common.MyBeanPostProcessor;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kayson.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kayson.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class Test5 {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:springPostProcessor.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        ProductService productService = beanFactory.getBean("productService", ProductService.class);
        String result = productService.getProductName();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
