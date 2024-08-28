package com.getcarro.interview.controller.product;

import com.getcarro.interview.model.product.ProductData;
import com.getcarro.interview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("productAPI")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> fetchProducts() {

        ProductData productData = this.productService.fetchProducts();

        return new ResponseEntity<>(productData, HttpStatus.OK);
    }

}