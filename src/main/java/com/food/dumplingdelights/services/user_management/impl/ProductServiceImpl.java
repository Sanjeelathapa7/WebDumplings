package com.food.dumplingdelights.services.user_management.impl;


import com.food.dumplingdelights.Entity.Product;
import com.food.dumplingdelights.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo){
        this.productRepo= productRepo;
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void edit(long id, Product newProduct) {
        Product found = productRepo.getOne(id);
        found.setName(newProduct.getName());
        found.setImageUrl(newProduct.getImageUrl());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }

//    @Override
//    public void save(Product product) {
//
//    }

    @Override
    public void delete(long id) {
        productRepo.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Product> findAllByCategoryId(long categoryId) {
        return productRepo.findAllByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return productRepo.count();
    }
}
