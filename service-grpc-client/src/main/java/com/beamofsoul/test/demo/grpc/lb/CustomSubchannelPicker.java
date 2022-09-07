package com.beamofsoul.test.demo.grpc.lb;

import io.grpc.LoadBalancer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现选择 Subchannel 的逻辑，这里使用的是轮询策略
 */
@Slf4j
public class CustomSubchannelPicker extends LoadBalancer.SubchannelPicker {

    private final AtomicInteger index = new AtomicInteger();

    private List<LoadBalancer.Subchannel> subchannelList;

    private LoadBalancer.PickResult pickResult;

    public CustomSubchannelPicker(LoadBalancer.PickResult pickResult) {
        this.pickResult = pickResult;
    }

    public CustomSubchannelPicker(List<LoadBalancer.Subchannel> subchannelList) {
        this.subchannelList = subchannelList;
    }

    @Override
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
        if (pickResult != null) {
            log.info("有错误的 pickResult，返回:{}", pickResult);
            return pickResult;
        }
        LoadBalancer.PickResult pickResult = nextSubchannel(args);
        log.info("Pick 下一个 Subchannel:{}", pickResult.getSubchannel());
        return pickResult;
    }

    /**
     * 在此方法中实现负载均衡策略选择目标 Subchannel
     * @param args
     * @return
     */
    private LoadBalancer.PickResult nextSubchannel(LoadBalancer.PickSubchannelArgs args) {
        if (index.get() >= subchannelList.size()) {
            index.set(0);
        }
        LoadBalancer.Subchannel subchannel = subchannelList.get(index.getAndIncrement());
        log.info("返回 Subchannel:{}", subchannel);
        return LoadBalancer.PickResult.withSubchannel(subchannel);
    }
}
