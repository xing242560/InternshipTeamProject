package com.example.demo01.controller;

import com.example.demo01.entity.product;
import com.example.demo01.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private productRepository repository;
    //1.获取产品信息
    @GetMapping("/product")
    public List<product> getall(){
        return repository.findAll();
    }
    //2.创建产品信息
    @PostMapping("/product")
    public product create(@RequestParam("name")String name,@RequestParam("price")Double price,@RequestParam("describe")String describe){
        product p=new product();
        p.setName(name);
        p.setDescribe(describe);
        p.setPrice(price);
        return repository.save(p);
    }
    //3.根据产品id查询产品
    @GetMapping("/product//{id}")
    public product find(@PathVariable("id")Integer id){
        return repository.findById(id).orElse(null);
    }
    //4.根据产品id更新产品信息；
    @PutMapping("/product//{id}")
    public product update(@PathVariable("id")Integer id,@RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "price",required = false)Double price,
                          @RequestParam(value = "describe",required = false)String describe){
        Optional<product> op=repository.findById(id);
        product p;
        if(op.isPresent()){
            p=op.get();
        }else {
            return null;
        }
        if(name!=null){
            p.setName(name);
        }
        if(price!=null){
            p.setPrice(price);
        }
        if(describe!=null){
            p.setDescribe(describe);
        }
        return repository.save(p);
    }
    //5.根据产品id删除产品信息；
    @DeleteMapping("/product//{id}")
    public String delete(@PathVariable("id")Integer id){
        Optional<product> op=repository.findById(id);
        product p;
        if(op.isPresent()){
            p=op.get();
            repository.delete(p);
            return "已删除";
        }else {
            return "id不存在";
        }

    }






}
