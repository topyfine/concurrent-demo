package com.awesome.chapter1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 杨帆
 * @date 2018/7/16 16:36
 * @desc v1.0.0
 */
@Slf4j
public class Producer implements Runnable {

    private FoodMachine foodMachine;

    public Producer(FoodMachine foodMachine) {
        this.foodMachine = foodMachine;
    }

    @Override
    public void run() {
        log.info(">>> {}->start produce", Thread.currentThread().getName());
        foodMachine.produce();
    }
}
