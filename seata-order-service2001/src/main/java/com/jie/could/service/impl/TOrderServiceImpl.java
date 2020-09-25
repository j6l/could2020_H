package com.jie.could.service.impl;

import com.jie.could.dao.TOrderDao;
import com.jie.could.entity.TOrder;
import com.jie.could.service.StorageService;
import com.jie.could.service.TOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2020-07-07 21:22:11
 */
@Service
@Slf4j
public class TOrderServiceImpl implements TOrderService {
    @Autowired
    private TOrderDao tOrderDao;
    @Autowired
    private StorageService storageService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrder queryById(Integer id) {
        return this.tOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TOrder> queryAllByLimit(int offset, int limit) {
        return this.tOrderDao.queryAllByLimit(offset, limit);
    }


    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    @GlobalTransactional(name = "jie_tx_group",rollbackFor = Exception.class)
    public TOrder insert(TOrder order) {
        log.info("----->开始新建订单");
        //新建订单
        this.tOrderDao.insert(order);

        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getTCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        // log.info("----->订单微服务开始调用账户，做扣减Money");
        // accountService.decrease(order.getUserId(),order.getMoney());
        // log.info("----->订单微服务开始调用账户，做扣减end");


        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        TOrder order1 = new TOrder();
        order1.setId(7);
        order1.setStatus(1);

        this.tOrderDao.update(order1);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");
        return order;
    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tOrderDao.deleteById(id) > 0;
    }
}