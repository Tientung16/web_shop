package com.example.backend.service.Impl;

import com.example.backend.dto.OrderDetailDTO;
import com.example.backend.entity.OrderDetail;
import com.example.backend.exception.DataNotFoundException;

import java.util.List;

public interface ImplOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception;
    OrderDetail getOrderDetail(Long id) throws DataNotFoundException;
    OrderDetail updateOrderDetail(Long id, OrderDetailDTO orderDetailDTO) throws DataNotFoundException;
    void deleteOrderDetail(Long id);
    List<OrderDetail> findByOrderId(Long orderId);
}
