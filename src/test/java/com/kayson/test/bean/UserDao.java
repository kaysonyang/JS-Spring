package com.kayson.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();


    static {
        hashMap.put("10001", "kayson");
        hashMap.put("10002", "tom");
        hashMap.put("10003", "lucy");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "kayson");
        hashMap.put("10002", "tom");
        hashMap.put("10003", "lucy");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

}
