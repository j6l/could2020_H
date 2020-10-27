payment8001 payment8002 生产者集群
server7001 server7002  eureka注册中心服务端
order80 80服务端
openfeign-order80  openfeign服务端

payment8006 consul注册中心生产者
consul-order80 consul注册中心消费者


hystrix8001 生产者
feign-hystrix80 消费者
