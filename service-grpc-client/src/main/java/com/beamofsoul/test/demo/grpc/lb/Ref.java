package com.beamofsoul.test.demo.grpc.lb;

/**
 * 用于保存 Subchannel 状态的工具类
 * @param <T>
 */
public class Ref<T> {
    T value;

    Ref(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
