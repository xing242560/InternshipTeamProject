package com.example.demo01.controller;

import com.example.demo01.entity.product;
import com.example.demo01.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class testController {
    @Autowired
    private productRepository pr;
    @GetMapping("/product/insert")
    public void insert(){
        product p1=new product();
        p1.setPrice(4.0);
        p1.setName("香蕉");
        p1.setDescribe("小香蕉");
        pr.save(p1);
        product p2=new product();
        p2.setPrice(24.0);
        p2.setName("菠萝蜜");
        p2.setDescribe("现剥");
        pr.save(p2);
    }

}
