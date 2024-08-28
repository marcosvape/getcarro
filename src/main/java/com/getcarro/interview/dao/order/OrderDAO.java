package com.getcarro.interview.dao.order;

import com.getcarro.interview.dao.order.mock.OrderMockData;
import com.getcarro.interview.model.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderDAO {

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);

    private final OrderMockData orderMock = new OrderMockData(new ArrayList<Order>(), new HashMap<Integer, List<Order>>(), 0);

    public Order createOrder(Order order, Integer userId) {
        return this.orderMock.insert(order, userId);
    }

    public List<Order> fetchUserOrders(Integer userId) {
        return this.orderMock.getUserOrders(userId);
    }

    public Order fetchOrder(Integer orderId) {
        return this.orderMock.getOrder(orderId);
    }

}
