package cn.com.wudskq.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenfangchao
 * @title: AtomicCounter
 * @projectName wc-manager-system
 * @description: TODO 原子计数类
 * @date 2022/7/4 12:54 AM
 */
public class AtomicCounter {

    private static final AtomicCounter atomicCounter = new AtomicCounter();

    /**
     * 单例，不允许外界主动实例化
     */
    private AtomicCounter() {

    }

    public static AtomicCounter getInstance() {
        return atomicCounter;
    }

    private static final AtomicInteger counter = new AtomicInteger();

    //获取值
    public int getValue() {
        return counter.get();
    }

    //递增
    public int increase() {
        return counter.incrementAndGet();
    }

    //递减
    public int decrease() {
        return counter.decrementAndGet();
    }

    // 清零
    public void toZero(){
        counter.set(0);
    }
}
