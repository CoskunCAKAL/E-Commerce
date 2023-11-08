package com.haratres.controller;

import com.haratres.dto.ProductWithStockDTO;
import com.haratres.entity.Product;
import com.haratres.entity.Role;
import com.haratres.entity.Stock;
import com.haratres.entity.User;
import com.haratres.repository.ProductRepository;
import com.haratres.repository.StockRepository;
import com.haratres.service.AccountService;
import com.haratres.service.ProductService;
import com.haratres.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin-panel")
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private final AccountService accountService;

    private final StockService stockService;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

@GetMapping("/save/{id}")
public String getSaveProductPage(Model model,@PathVariable("id") Long id){

    model.addAttribute("product",new Product());


    return "admin/product-add";
}


    @PostMapping(value = "/save")
    public String saveNewProduct(@ModelAttribute("product")Product product,Model model){

        Stock stock = new Stock();
        stock= stockService.getStockById(product.getId());
        stock.setCount(stock.getCount()+5);


        productService.saveProduct(product);

        return "redirect:/admin-panel";
    }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeStockCount(Model model,@PathVariable("id") Long id){

        Stock stock= stockRepository.findStockByProductId(id);
        stock.setCount(stock.getCount()-1);
        stockService.saveStock(stock);
        return "redirect:/admin-panel";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addStockCount(Model model,@PathVariable("id") Long id){

        Stock stock= stockRepository.findStockByProductId(id);
        stock.setCount(stock.getCount()+1);
        stockService.saveStock(stock);
        return "redirect:/admin-panel";
    }
    @GetMapping
    public String getAllProduct(Model model){
        List<ProductWithStockDTO> dtos = new ArrayList<>();
        for (Product product : productService.getAllProduct()) {
            ProductWithStockDTO productWithStockDTO = new ProductWithStockDTO();
            productWithStockDTO.setProduct(product);
            productWithStockDTO.setAvailableStock(stockService.findAvailableStockForProductId(product.getId()));

            dtos.add(productWithStockDTO);

        }
        model.addAttribute("products",dtos);

        return "admin/admin-panel";
    }
    @GetMapping("removeProduct/{id}")
    public String removeProduct(Model model, @PathVariable("id") Long id){
//        Product product = new Product();
        for (Product product : productService.getAllProduct())
        if (product.getId().equals(id)){
            productService.deleteProductById(id);
        }


        return "admin/admin-panel";
    }

//    @GetMapping("/stock")
//    public String stock(Model model){
//
//        model.addAttribute("stocks",stockService.getAllStock());
//
//        return "admin/admin-panel";
//    }
//    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
//    public String updateProduct(@ModelAttribute("product") Product product){
//
//        product.setId(product.getId());
//        product.setImages(product.getImages());
//        product.setMemory(product.getMemory());
//        product.setPrice(product.getPrice());
//        product.setDescription(product.getDescription());
//        product.setBaseImage(product.getBaseImage());
//        product.setStorage(product.getStorageText());
//        product.setTitle(product.getTitle());
//        product.setPoweradapter(product.getPoweradapter());
//        productService.saveProduct(product);
//
//
//        return "admin/admin-panel";
//    }
}
