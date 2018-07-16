package com.awesome.chapter1;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author 杨帆
 * @date 2018/7/16 16:05
 * @desc v1.0.0
 */
@Slf4j
public class FoodMachine {
    private Stack<String> stack = new Stack<>();

    public synchronized void produce() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            String food = "food->" + i;
            stack.push(food);
            log.info(">>> produce {}", food);
        }
        notifyAll();
    }

    public synchronized void consume() {
        while (stack.size() < 1) {
            try {
                log.info(">>> {}:no food then wait", Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                log.warn(">>> 消费异常", e);
            }
        }
        while (stack.size() > 1) {
            String food = stack.pop();
            log.info(">>> {}:consume {}", Thread.currentThread().getName(), food);
            // 让其他消费
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
