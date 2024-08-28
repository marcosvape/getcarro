package com.getcarro.interview.dao.product;

import com.getcarro.interview.model.product.ProductData;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

    public ProductData loadProducts() {
        try {
            InputStream inputStream = ProductDAO.class.getClassLoader().getResourceAsStream("products.json");

            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            ProductData products = gson.fromJson(json, ProductData.class);

            return products;

//            Type productListType = new TypeToken<List<Product>>() {}.getType();
//            List<Product> products = gson.fromJson(json, productListType);

        } catch (Exception e) {
            logger.error("error trying to load products with error {}", e.getMessage());
            return null;
        }
    }

}
