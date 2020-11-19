package com.fastcampus.demo.repository;

import com.fastcampus.demo.DemoApplicationTests;
import com.fastcampus.demo.model.entity.OrderDetail;
import com.fastcampus.demo.model.repository.OrderDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends DemoApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());
//        orderDetail.setItemId(1L);
//        orderDetail.setUserId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }
}
