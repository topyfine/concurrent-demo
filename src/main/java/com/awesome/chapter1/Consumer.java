package com.awesome.chapter1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 杨帆
 * @date 2018/7/16 16:47
 * @desc v1.0.0
 */
@Slf4j
public class Consumer implements Runnable {
    private FoodMachine foodMachine;

    public Consumer(FoodMachine foodMachine) {
        this.foodMachine = foodMachine;
    }

    @Override
    public void run() {
        log.info(">>> {}->start consume", Thread.currentThread().getName());
        foodMachine.consume();
    }
}
