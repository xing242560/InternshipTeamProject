package com.mm.controller;

import com.mm.entity.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController controller;

    @Test
    void getAll() {
        Assert.assertNotNull(controller.getAll());
    }


    @Test
    void create() {
        Product p=new Product();
        controller.create("111",123,"1");

    }

    @Test
    void findById() {
        Assert.assertNotEquals(null,controller.findById(2));

    }

    @Test
    void update() {
        controller.update(4,"锅",234.00,"");
         Assert.assertNotEquals(null,controller.findById(4));
    }

    @Test
    void delete() {
        controller.delete(2);
        Assert.assertEquals(null,controller.findById(2));
    }
}