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
public class VariantNode {
    private String id;
    private int quantity;
    private String sku;
    private boolean allowOversell;
    private long createdAt;
    private String displayName;
    private Image image;
    private boolean inventoryTracked;
    private int position;
    private String productId;
    private List<String> selectedOptions;
    private boolean taxable;
    private String taxCode;
    private String title;
    private long updatedAt;
    private double weight;
    private String weightUnit;
    private VariantMetadata variantMetadata;
}
