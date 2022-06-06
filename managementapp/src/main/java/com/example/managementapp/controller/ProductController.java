package com.example.managementapp.controller;


import com.example.managementapp.entity.DepositModel;
import com.example.managementapp.entity.ProductModel;
import com.example.managementapp.service.DepositService;
import com.example.managementapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private DepositService depositService;

    @GetMapping("getProducts")
    public String viewProducts (Model model){

        List<ProductModel> productModelsList = productService.getProducts();
        model.addAttribute("products", productModelsList);
        return "index";
    }

    @GetMapping("add-product")
    public String addProduct (Model model) {

        List<DepositModel> depositModels = depositService.getDeposits();

        model.addAttribute("products", new ProductModel());
        model.addAttribute("deposits", depositModels);
        return "add-product";
    }

    @PostMapping("add-new-product")
    public String addNewProduct (ProductModel productModel){
        productService.addProduct(productModel);
        return "redirect:/getProducts";
    }

    @GetMapping("edit-product/{productId}")
    public String editProductPage(@PathVariable("productId") int productId, Model model) throws ProductNoFoundException {

        ProductModel productModel = productService.getProducts(productId);

        List<DepositModel> deposit = depositService.getDeposits();
        model.addAttribute("deposits", deposit);
        model.addAttribute("products", productModel);

        return "edit-product";
    }


    @PostMapping("edit-new-product")
    public String editProduct(ProductModel productModel) throws ProductNoFoundException {
        productService.updateProduct(productModel);
        return "redirect:/getProducts";
    }

    @GetMapping("delete-product-page/{id}")
    public String deleteProduct (@PathVariable("id") int productId) {

        productService.removeProduct(productId);
        return "redirect:/getProducts";
    }
}
