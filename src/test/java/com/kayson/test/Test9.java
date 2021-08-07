package com.kayson.test;

import com.kayson.springframework.context.support.ClassPathXmlApplicationContext;
import com.kayson.test.bean.UserService;
import com.kayson.test.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class Test9 {



    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
