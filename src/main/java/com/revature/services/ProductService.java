package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.dao.DAO;
import com.revature.models.Product;

public class ProductService {
    private DAO<Product> productDAO;

    public ProductService(DAO<Product> productDAO){
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.getAllInstances();
    }

    public Product getProductById(int id){
        List<Product> listOfProducts = getAllProducts();

        Optional<Product> foundProduct = listOfProducts.stream()
        .filter((product) -> product.getProductId() == id)
        .findFirst();

        if(foundProduct.isPresent()){
            return foundProduct.get();
        } else {
            Product product = new Product();
            product.setName("Not Found");
            return product;
        }
    }

    public Product addProduct(Product product){
        
        return productDAO.addInstance(product);
    }
}
