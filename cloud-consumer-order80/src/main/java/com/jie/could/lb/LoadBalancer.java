package com.jie.could.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
