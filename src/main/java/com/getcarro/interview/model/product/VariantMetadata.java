package com.getcarro.interview.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VariantMetadata {
    private double minimumRetailerSalePrice;
    private double maximumRetailerSalePrice;
    private double supplierCutPercentage;
    private double supplierEffectivePrice;
    private String supplierRevSplitOption;
}
