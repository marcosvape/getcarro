package com.getcarro.interview.controller.order.dto;

import com.getcarro.interview.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateResponse {

    private List<UserError> userErrors;
    private Order order;

}