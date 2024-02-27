package com.spring.data.service;

import com.spring.data.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<Product> findAllByPrice(double price, Pageable pageable);

}
