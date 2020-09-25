package com.jie.could.web;

import com.jie.could.entity.CommonResult;
import com.jie.could.entity.Payment;
import com.jie.could.service.iml.PaymentServiceiml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/1
 * WWW https://github.com/j6l
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentServiceiml serviceiml;

    @Value( "${server.port}" )
    private String ServiceProt;

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create" )
    public CommonResult create(@RequestBody Payment payment){
        int i = serviceiml.create( payment );
        log.info( "插入结果===="+i );

        if (i>0){
            return new CommonResult(200,"插入成功,serverPort"+ServiceProt,i);
        }else{
            return new CommonResult(444,"插入失败,serverPort"+ServiceProt,null);
        }
    }

    @GetMapping(value="/payment/get/{id}" )
    public CommonResult GetPaymentId(@PathVariable("id") Long id) {
        Payment i = serviceiml.getPaymentById( id );
        log.info( "查询结果===="+i );

        if (i != null){
            return new CommonResult(200,"查询成功,serverPort"+ServiceProt,i);
        }else{
            return new CommonResult(444,"没有对应记录,查询id为,serverPort"+ServiceProt+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances( "CLOUD-PAYMENT-SERVICE" );
        for(ServiceInstance instance: instances){
            log.info( instance.getServiceId()+"\t" + instance.getHost() +
                    "\t" + instance.getPort() +"\t" + instance.getUri() );
        }
        return  this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return ServiceProt;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }


}
