package com.SportyShoes.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.website.models.Products;

public interface ProductRepository extends CrudRepository<Products, Integer> {

}
