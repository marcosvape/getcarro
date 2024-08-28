package com.getcarro.interview.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDataEdges {
    private List<Product> edges;
    private ProductPageInfo pageInfo;
}
