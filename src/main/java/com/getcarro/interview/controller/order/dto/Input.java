package com.getcarro.interview.controller.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Input {

    private String orderName;
    private DestinationAddress destinationAddress;
    private List<LineItem> lineItems;

}