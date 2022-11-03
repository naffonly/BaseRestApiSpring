package com.example.ResfulAPIweb.Services;


import com.example.ResfulAPIweb.Models.Repositorys.ProductRepo;
import com.example.ResfulAPIweb.Models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ProducService {

    @Autowired
    private ProductRepo productRepo;

    public Product save (Product product){
        return  productRepo.save(product);
    }

    public Product findOne (Integer id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void  removeOne(Integer id){
         productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
