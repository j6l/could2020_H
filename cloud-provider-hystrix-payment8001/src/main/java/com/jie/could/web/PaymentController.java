package com.jie.could.web;

import com.jie.could.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    private PaymentService paymentService;

    @Value( "${server.port}" )
    private String ServiceProt;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }


    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker( id );
        return s;
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

}
