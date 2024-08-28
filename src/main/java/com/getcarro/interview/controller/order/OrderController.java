package com.getcarro.interview.controller.order;

import com.getcarro.interview.controller.order.dto.OrderCreateOrUpdateInput;
import com.getcarro.interview.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("orderAPI")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // If i had more time i would control the exceptions and return the proper HTTP status for each scenario
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> orderCreate(@RequestBody OrderCreateOrUpdateInput input, @RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<>(this.orderService.createOrder(input, userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{orderId}/status", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> fetchOrderStatus(@PathVariable(name = "orderId") Integer orderId) {
        String orderStatus = this.orderService.fetchOrderStatus(orderId);
        if (orderStatus != null) {
            return new ResponseEntity<>(orderStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Ideally userId should be fetch from the user JWT for security purposes
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> fetchUserOrders(@RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<>(this.orderService.fetchUserOrders(userId), HttpStatus.OK);
    }

}