package com.awesome.chapter1;

/**
 * @author 杨帆
 * @date 2018/7/16 16:51
 * @desc v1.0.0
 */
public class Launcher {
    public static void main(String[] args) {
        FoodMachine foodMachine = new FoodMachine();
        new Thread(new Producer(foodMachine)).start();
        new Thread(new Consumer(foodMachine)).start();
        new Thread(new Consumer(foodMachine)).start();
        new Thread(new Consumer(foodMachine)).start();
        new Thread(new Consumer(foodMachine)).start();
    }
}
