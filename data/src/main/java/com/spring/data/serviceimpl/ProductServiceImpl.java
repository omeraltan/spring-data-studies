package com.spring.data.serviceimpl;

import com.spring.data.entity.Product;
import com.spring.data.repository.ProductRepository;
import com.spring.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAllByPrice(double price, Pageable pageable) {
        return repository.findAllByPrice(price, pageable);
    }
}
