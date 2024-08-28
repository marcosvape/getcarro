package com.getcarro.interview.model.order;

import com.getcarro.interview.controller.order.dto.DestinationAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private DestinationAddress address;
    private String brandType;
    private String externalOrderId;
    private String fulfillmentStatus;
    private int id;
    private boolean isTest;
    private String name;
    private String notes;
    private String status;
    private String statusV2;
    private double totalLineItemsAmount;
    private double totalOrderAmount;
    private double totalShippingAmount;
    private String createdAt;
    private String updatedAt;
}