package com.kayson.test.bean;

import lombok.ToString;

@ToString
public class ProductService {

    private String name;
    private UserDao userDao;
    private String uId;


    public ProductService() {
    }

    public ProductService(String name) {
        this.name = name;
    }

    public String getProductName() {
        String item = "water";
        return item;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }
}
