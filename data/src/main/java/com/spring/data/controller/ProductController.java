package com.spring.data.controller;

import com.spring.data.entity.Product;
import com.spring.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/page") // For Example : http://localhost:8080/product/page?priceId=1000
    public ResponseEntity<List<Product>> getProducts(@RequestParam(value = "priceId") double price){
        Pageable pageable = PageRequest.of(0,10, Sort.by("price").descending().and(Sort.by("name")));
        return ResponseEntity.ok().body(service.findAllByPrice(price, pageable));
    }

}
