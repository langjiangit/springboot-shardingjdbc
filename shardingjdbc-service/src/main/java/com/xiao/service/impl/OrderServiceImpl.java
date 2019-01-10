package com.xiao.service.impl;

import com.xiao.dao.mapper.OrderMapper;
import com.xiao.domain.dto.Order;
import com.xiao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunjinwei on 2019/1/10.
 *
 * @author sunjinwei
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void saveOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public Order selectOrder(Order order) {
        return orderMapper.selectOrder(order);
    }

}
