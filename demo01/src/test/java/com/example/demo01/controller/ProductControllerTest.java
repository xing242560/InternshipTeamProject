package com.example.demo01.controller;

import com.example.demo01.entity.product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Test
    void getall() {
        Assert.assertNotNull(productController.getall());
        System.out.println("通过");
    }

    @Test
    void create() {
        product p=new product();
        p=productController.create("苹果",2.4,"国光");

    }

    @Test
    void find() {
        Assert.assertNotEquals(null,productController.find(1));
        System.out.println("通过");
    }

    @Test
    void update() {
        productController.update(2,"火龙果",8.5,"wu");
        Assert.assertNotEquals(null,productController.find(2));
    }

    @Test
    void delete() {
        productController.delete(1);
        Assert.assertEquals(null,productController.find(1));

    }
}