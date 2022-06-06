package com.example.managementapp.service;

import com.example.managementapp.controller.ProductNoFoundException;
import com.example.managementapp.dao.DepositRepository;
import com.example.managementapp.dao.ProductRepository;
import com.example.managementapp.entity.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DepositRepository depositRepository;

    public void addProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public void removeProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> getProducts(){
        List<ProductModel> productModels = productRepository.findAll();
        return productModels;
    }
    public ProductModel getProducts(int productId) throws ProductNoFoundException {
        Optional<ProductModel> optionalProductModel = productRepository.findById(productId);
        if (optionalProductModel.isEmpty()) {
            throw new ProductNoFoundException("Product with id:" + productId + "doesn't exist");
        }

        ProductModel productModel = optionalProductModel.get();

        return productModel;
    }



    public void updateProduct(ProductModel modifiedProduct) throws ProductNoFoundException {

        ProductModel productModel1 = getProducts(modifiedProduct.getId());

        productModel1.setName(modifiedProduct.getName());
        productModel1.setProducer(modifiedProduct.getProducer());
        productModel1.setDescription(modifiedProduct.getDescription());
        productModel1.setLot(modifiedProduct.getLot());
        productModel1.setQuantity(modifiedProduct.getQuantity());

        productModel1.setDepositModel(modifiedProduct.getDepositModel());
        productRepository.save(modifiedProduct);
    }
}
