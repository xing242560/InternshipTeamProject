package com.example.demo01.repository;

import com.example.demo01.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product,Integer> {
}
