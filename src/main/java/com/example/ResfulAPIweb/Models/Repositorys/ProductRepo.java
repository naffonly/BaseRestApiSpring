package com.example.ResfulAPIweb.Models.Repositorys;

import com.example.ResfulAPIweb.Models.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findByNameContains(String name);

}
