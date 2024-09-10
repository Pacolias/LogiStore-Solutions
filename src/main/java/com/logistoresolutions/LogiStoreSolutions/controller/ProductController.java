package com.logistoresolutions.LogiStoreSolutions.controller;

import com.logistoresolutions.LogiStoreSolutions.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        //Sample products
        Product p1 = new Product("XLR8", "Product 1", 10.0);
        Product p2 = new Product("XLR9", "Product 2", 20.0);

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);

        //returns a list with "all the products" that we have
        return productList;
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable String id){
        //Sample product with the provided id (we still dont have database)
        Product p = new Product(id, "Product", 27.0);
        return p;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product p){
        //We will have to change how this method works once we have a data base
        return "Product with id: " + p.getId() + " successfully created";
    }

    @PutMapping("/updatePrice/{id}")
    public String updatePriceById(@PathVariable String id, @RequestBody String price){
        try {
            double priceValue = Double.parseDouble(price);
            return "Product with id: " + id + " has been updated successfully. It costs: " + priceValue;
        } catch (NumberFormatException e) {
            return "Invalid price format";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        return "Product with id: " + id + " has been deleted successfully";
    }
}
