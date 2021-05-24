package com.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejava.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
