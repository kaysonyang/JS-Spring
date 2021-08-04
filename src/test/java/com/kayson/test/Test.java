package com.kayson.test;

import com.kayson.test.bean.ProductService;
import com.kayson.springframework.beans.factory.config.BeanDefinition;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;

public class Test {
    public static void main(String[] args) {
        /*
        //init beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // define bean and register
        BeanDefinition beanDefinition = new BeanDefinition(new ProductService());

        // get bean from bean factory
        beanFactory.registerBeanDefinition("productService", beanDefinition);
        ProductService productService = (ProductService) beanFactory.getBean("productService");

        // done
        System.out.println(productService.getProductName());
        */


        // 1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.register bean
        BeanDefinition beanDefinition = new BeanDefinition(ProductService.class);
        beanFactory.registerBeanDefinition("productService", beanDefinition);
        // 3.get bean from bean factory
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        productService.getProductName();
        // 4.get bean from Singleton
        ProductService productService_singleton = (ProductService) beanFactory.getBean("productService");
        String productName = productService_singleton.getProductName();
        System.out.println(productName);
    }
}
