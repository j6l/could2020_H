package com.jie.could.web;

import com.jie.could.entity.CommonResult;
import com.jie.could.entity.Payment;
import com.jie.could.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@RestController
@Slf4j
public class OrderContrpller {

    // public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject( PAYMENT_URL+"/payment/create",payment, CommonResult.class );
    }

    @GetMapping("/consumer/payment/get/{id}")
    public  CommonResult<Payment> getpayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject( PAYMENT_URL+"/payment/get/"+id, CommonResult.class );
    }

    @GetMapping("/consumer/payment/getF/{id}")
    public  CommonResult<Payment> getpayment1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity( PAYMENT_URL + "/payment/get/" + id, CommonResult.class );
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/createF")
    public CommonResult<Payment> create1(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity( PAYMENT_URL + "/payment/create", payment, CommonResult.class );
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult(444,"插入数据失败");
        }
    }


    /**
     * 手写轮询
     * 需要屏蔽设置里@LoadBalanced注解才可使用
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> list = discoveryClient.getInstances( "CLOUD-PAYMENT-SERVICE" );
        if (list == null || list.size() <= 0){
            return null;
        }else {
            ServiceInstance instance = loadBalancer.instance( list );
            URI uri = instance.getUri();
            return restTemplate.getForObject( uri+"/payment/lb",String.class );
        }
    }


    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
        return result;
    }
}