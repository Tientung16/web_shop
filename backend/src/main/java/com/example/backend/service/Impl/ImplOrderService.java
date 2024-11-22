package com.example.backend.service.Impl;


import com.example.backend.dto.OrderDTO;
import com.example.backend.entity.Order;
import com.example.backend.exception.DataNotFoundException;

import java.util.List;

public interface ImplOrderService {
    Order createOrder(OrderDTO orderDTO) throws Exception;
    Order getOrderById(Long id);

    List<Order> findByUserId(Long userId);
    Order updateOrder(Long id, OrderDTO orderDTO) throws DataNotFoundException;
    void deleteOrder(Long id);
}
