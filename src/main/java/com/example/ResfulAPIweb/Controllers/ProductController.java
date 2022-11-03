package com.example.ResfulAPIweb.Controllers;

import com.example.ResfulAPIweb.Models.entities.Product;
import com.example.ResfulAPIweb.Services.ProducService;
import com.example.ResfulAPIweb.dto.ResponsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    @Autowired
    private ProducService productService;

    @PostMapping
    public ResponseEntity<ResponsData<Product>> create(@Valid @RequestBody Product product, Errors errors){

        ResponsData<Product> responsData = new ResponsData<>();


        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responsData.getMessages().add(error.getDefaultMessage());
            }
            responsData.setStatus(false);
            responsData.setPayload(null);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsData);
        }
        responsData.setStatus(true);
        responsData.setPayload(productService.save(product));
        return ResponseEntity.ok(responsData);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }


    @GetMapping("/id/{id}")
    public Product findOne(@PathVariable("id") Integer id){
        return  productService.findOne(id);
    }

    @PutMapping
    public  ResponseEntity<ResponsData<Product>> update(@Valid @RequestBody Product product,Errors errors){
        ResponsData<Product> responsData = new ResponsData<>();


        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responsData.getMessages().add(error.getDefaultMessage());
            }
            responsData.setStatus(false);
            responsData.setPayload(null);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsData);
        }
        responsData.setStatus(true);
        responsData.setPayload(productService.save(product));
        return ResponseEntity.ok(responsData);
    }

    @DeleteMapping("/id/{id}")
    public void removeOne(@PathVariable("id") Integer id){
        productService.removeOne(id);
    }

}
