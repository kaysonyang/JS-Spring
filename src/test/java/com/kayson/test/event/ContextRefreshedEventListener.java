package com.kayson.test.event;

import com.kayson.springframework.context.ApplicationListener;
import com.kayson.springframework.context.event.ContextClosedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
