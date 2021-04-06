package com.mm.controller;

import com.mm.Repository.ProductRepository;
import com.mm.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ProductController {
 @Autowired
    private ProductRepository repository;

 /*
 1.获取所有信息
  */
    @GetMapping("/products")
    public List<Product> getAll(){
        return repository.findAll();
    }
    /*
    2.创建一条学生信息
     */
    @PostMapping("/students")
    public Product create(@RequestParam("name")String name,@RequestParam("price")double price,@RequestParam("description")String description){
        Product product =new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return repository.save(product);
    }
    /*
    3.通过ID查找
     */
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse( null);
    }
    /*
    4.通过ID更新产品信息
     */
    @PutMapping("/products/{id}")
            public Product update(@PathVariable("id")Integer id,@RequestParam(value = "name",required = false)String name,
                    @RequestParam(value = "price",required = false)Double price,
                    @RequestParam(value = "description",required = false)String description) {
                Optional<Product> optional=repository.findById(id);
                Product product;
                if(optional.isPresent()){
                    product =optional.get();
        }else {
            return null;
        }
        if(name!=null){
            product.setName(name);
        }if(price!=null){
            product.setPrice(price);
        }if(description!=null){
            product.setDescription(description);
        }
        return repository.save(product);
    }

    /*
    4.根据ID删除产品信息
     */

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") Integer id){
        Optional<Product> optional=repository.findById(id);
        Product product;
        if(optional.isPresent()){
            product =optional.get();
            repository.delete(product);
            return "删除成功";
        }else {
            return "ID不存在";
        }


    }

}
