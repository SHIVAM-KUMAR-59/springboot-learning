package com.shivam._2.SpringBootECommerceExample.service;

import com.shivam._2.SpringBootECommerceExample.model.Product;
import com.shivam._2.SpringBootECommerceExample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        Optional<Product> product = repository.findById(id);
        return product.orElse(new Product(-1));
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repository.save(product);

    }

    public boolean deleteProduct(int id){
        repository.deleteById(id);
        return true;
    }

    public List<Product> searchProducts(String keyword){
        return repository.searchProducts(keyword);
    }

}