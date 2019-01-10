package com.xiao.service;

import com.xiao.domain.dto.Order;

/**
 * Created by sunjinwei on 2019/1/10.
 *
 * @author sunjinwei
 */
public interface OrderService {
    void saveOrder(Order order);

    Order selectOrder(Order order);
}
