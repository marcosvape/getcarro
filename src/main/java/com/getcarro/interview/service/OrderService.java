package com.getcarro.interview.service;

import com.getcarro.interview.controller.order.dto.LineItem;
import com.getcarro.interview.controller.order.dto.OrderCreateOrUpdateInput;
import com.getcarro.interview.dao.order.OrderDAO;
import com.getcarro.interview.model.order.Order;
import com.getcarro.interview.model.order.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductService productService;

    public Order createOrder(OrderCreateOrUpdateInput orderCreateInput, Integer userId) {

        try {
            logger.info("creating a new order {}", orderCreateInput.getInput().getOrderName());
            LocalDate currentDate = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            Order order = new Order();

            Double totalOrderAmount = 0.0;
            Double totalLineOrderAmount = 0.0;

            //not sure if thats the correct business logic but tried to add some validations
            for (LineItem item : orderCreateInput.getInput().getLineItems()) {
                if (item.getPrice() >= 0.0) {
                    if (item.getQuantity() > 0) {

                        productService.fetchProducts().getData().getProducts().getEdges().forEach(edge -> {
                            edge.getNode().getVariants().getEdges().forEach(nodeEdge -> {
                                if (Objects.equals(nodeEdge.getNode().getId(), item.getVariantId())) {
                                    //not sure what to do with the product that i found cuz we already have everything we need
                                    // from the payload to create the order
                                    logger.info("found the product intended");
                                }
                            });
                        });

                        totalLineOrderAmount++;
                        totalOrderAmount += item.getPrice();
                    } else {
                        logger.info("quantity must be bigger than 0 for item {}", item.getVariantId());
                    }
                } else {
                    logger.info("price must be positive for item {}", item.getVariantId());
                }
            }

            order.setCreatedAt(currentDate.format(formatter));
            order.setAddress(orderCreateInput.getInput().getDestinationAddress());
            order.setName(orderCreateInput.getInput().getOrderName());
            order.setStatus(OrderStatus.NEW.toString());
            order.setUpdatedAt(currentDate.format(formatter));
            order.setStatusV2(OrderStatus.NEW.toString());
            order.setTest(true);
            order.setTotalLineItemsAmount(orderCreateInput.getInput().getLineItems().size());
            order.setTotalOrderAmount(orderCreateInput.getInput().getLineItems().size());
            order.setTotalShippingAmount(0.0);

            return this.orderDAO.createOrder(order, userId);

        } catch (Exception e) {
            logger.error("Error while creating order", e);
            return null;
        }
    }

    public List<Order> fetchUserOrders(Integer userId) {
        logger.info("fetching user orders for user {}", userId);
        return this.orderDAO.fetchUserOrders(userId);
    }

    public String fetchOrderStatus(Integer orderId) {
        logger.info("fetching order status for order {}", orderId);
        Order order = this.orderDAO.fetchOrder(orderId);

        if (order != null) {
            return order.getStatus();
        } else {
            return null;
        }
    }

}