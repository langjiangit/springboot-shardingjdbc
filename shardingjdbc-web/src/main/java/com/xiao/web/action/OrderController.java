package com.xiao.web.action;

import cn.hutool.core.date.DateUtil;
import com.xiao.domain.dto.Order;
import com.xiao.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunjinwei on 2019/1/10.
 *
 * @author sunjinwei
 */
@Slf4j
@Api(description = "测试分库分表")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "测试插入0库0表")
    @RequestMapping(value = "/saveDs0Table0", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveDs0Table0() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("time", DateUtil.now());
        log.info("### saveDs0Table0");

        //分库原则 user_id 是偶数对应 ds0
        //分表原则 order_id 是偶数对应 t_order_0
        Order order = new Order();
        order.setUserId(10);
        order.setOrderId(10L);
        order.setStatus("0库0表");

        orderService.saveOrder(order);
        resultMap.put("order", order);
        resultMap.put("table", "saveDs0Table0");

        return resultMap;
    }

    @ApiOperation(value = "测试插入0库1表")
    @RequestMapping(value = "/saveDs0Table1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveDs0Table1() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("time", DateUtil.now());
        log.info("### saveDs0Table1");

        //分库原则 user_id 是偶数对应 ds0
        //分表原则 order_id 是偶数对应 t_order_0
        Order order = new Order();
        order.setUserId(10);
        order.setOrderId(11L);
        order.setStatus("0库1表");

        orderService.saveOrder(order);
        resultMap.put("order", order);
        resultMap.put("table", "saveDs0Table1");

        return resultMap;
    }

    @ApiOperation(value = "测试插入1库0表")
    @RequestMapping(value = "/saveDs1Table0", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveDs1Table0() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("time", DateUtil.now());
        log.info("### saveDs1Table0");

        //分库原则 user_id 是偶数对应 ds0
        //分表原则 order_id 是偶数对应 t_order_0
        Order order = new Order();
        order.setUserId(11);
        order.setOrderId(10L);
        order.setStatus("1库0表");

        orderService.saveOrder(order);
        resultMap.put("order", order);
        resultMap.put("table", "saveDs1Table0");

        return resultMap;
    }

    @ApiOperation(value = "测试插入1库1表")
    @RequestMapping(value = "/saveDs1Table1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveDs1Table1() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("time", DateUtil.now());
        log.info("### saveDs1Table1");

        //分库原则 user_id 是偶数对应 ds0
        //分表原则 order_id 是偶数对应 t_order_0
        Order order = new Order();
        order.setUserId(11);
        order.setOrderId(11L);
        order.setStatus("1库1表");

        orderService.saveOrder(order);
        resultMap.put("order", order);
        resultMap.put("table", "saveDs1Table1");

        return resultMap;
    }


    @ApiOperation(value = "查询")
    @RequestMapping(value = "/getDsXTableX", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDsXTableX(@ApiParam(value = "偶数对应 ds0") @RequestParam String userId,
                                            @ApiParam(value = "偶数对应 table0") @RequestParam String orderId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("time", DateUtil.now());
        log.info("### getDsXTableX");

        //分库原则 user_id 是偶数对应 ds0
        //分表原则 order_id 是偶数对应 t_order_0
        Order order = new Order();
        order.setUserId(Integer.valueOf(userId));
        order.setOrderId(Long.valueOf(orderId));
        Order result = orderService.selectOrder(order);

        resultMap.put("order", result);
        resultMap.put("table", result.getStatus());

        return resultMap;
    }

}
