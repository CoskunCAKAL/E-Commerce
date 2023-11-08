package com.haratres.controller;

import com.haratres.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product/product-list";
    }

    @GetMapping("/{id}")
    public String getCartById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/product-detail";
    }


}
