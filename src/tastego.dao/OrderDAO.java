package com.tastego.dao;

import java.util.List;

import com.tastego.model.Order;

public interface OrderDAO {

    boolean placeOrder(Order order);

    List<Order> getOrdersByUser(int userId);

    List<Order> getAllOrders();

}
