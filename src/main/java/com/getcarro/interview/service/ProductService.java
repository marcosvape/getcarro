package com.getcarro.interview.service;

import com.getcarro.interview.dao.product.ProductDAO;
import com.getcarro.interview.model.product.ProductData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductDAO productDAO;

    public ProductData fetchProducts() {
        ProductData productData = this.productDAO.loadProducts();

        logger.info("fetching products : {}", productData);

        return productData;
    }

}
