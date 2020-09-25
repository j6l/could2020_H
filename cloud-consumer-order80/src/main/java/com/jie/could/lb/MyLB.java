package com.jie.could.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger  = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current,next;

        for (;;){
            current = this.atomicInteger.get();
            next = current >= 1024 ? 0 : current+1;
            if (this.atomicInteger.compareAndSet( current,next )){
                System.out.println( "***********第几次访问"+next );
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
