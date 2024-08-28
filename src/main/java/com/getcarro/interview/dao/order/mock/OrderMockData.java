package com.getcarro.interview.dao.order.mock;

import com.getcarro.interview.model.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderMockData {

    private final List<Order> orders;

    private final Map<Integer, List<Order>> userOrders;

    private Integer sequence;

    // stateful in memory DB
    public OrderMockData(List<Order> orders, Map<Integer, List<Order>> userOrders, Integer sequence) {
        this.orders = orders;
        this.userOrders = userOrders;
        this.sequence = sequence;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(Integer id) {
        Order order = null;
        for (Order o : orders) {
            if (o.getId() == id) {
                order = o;
            }
        }

        return order;
    }

    public List<Order> getUserOrders(Integer userId) {
        List<Order> userOrders = this.userOrders.get(userId);

        if (userOrders == null) {
            userOrders = new ArrayList<>();
        }

        return userOrders;
    }

    public Order insert(Order order, Integer userId) {
        sequence++;
        order.setId(sequence);

        List<Order> currentUserOrders = this.userOrders.get(userId);

        if (currentUserOrders != null) {
            currentUserOrders.add(order);
        } else {
            currentUserOrders = new ArrayList<Order>();
            currentUserOrders.add(order);
        }

        this.userOrders.put(userId, currentUserOrders);

        this.orders.add(order);

        return order;
    }

}