package com.kaysom.test;

import cn.hutool.core.io.IoUtil;
import com.kaysom.test.bean.ProductService;
import com.kayson.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kayson.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kayson.springframework.core.io.DefaultResourceLoader;
import com.kayson.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class Test4 {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/kaysonyang/JS-Spring/important.properties");
                InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }


    @Test
    public void test_xml() {
        // 1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        ProductService productService = beanFactory.getBean("productService", ProductService.class);
        String result = productService.getProductName();
        System.out.println(result);
    }
}
