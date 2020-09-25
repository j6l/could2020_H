package com.jie.could.web;

import com.alibaba.fastjson.JSON;
import com.jie.could.entity.CommonResult;
import com.jie.could.entity.TOrder;
import com.jie.could.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/15
 * WWW https://github.com/j6l
 */
@RestController
// @RefreshScope
public class OrderController {

    @Autowired
    private TOrderService orderService;


    @GetMapping("/order/create")
    // public CommonResult create(Order order)
    public CommonResult create()
    {
        TOrder order = new TOrder();

        order.setUserId(13);
        order.setProductId(1);
        order.setTCount(2);
        order.setMoney(23.2D);
        order.setStatus(1);


        orderService.insert(order);
        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/order/list")
    // public CommonResult create(Order order)
    public CommonResult list(){
        List<TOrder> list = orderService.queryAllByLimit( 0,10 );
        String s = JSON.toJSONString( list );
        System.out.println( s );
        return new CommonResult(200,s );
    }
    @GetMapping("/order/id/{id}")
    // public CommonResult create(Order order)
    public CommonResult getid(@PathVariable("id") Integer id) {
        TOrder list = orderService.queryById( id );
        String s = JSON.toJSONString( list );
        System.out.println( s );
        return new CommonResult(200,s );
    }

}
