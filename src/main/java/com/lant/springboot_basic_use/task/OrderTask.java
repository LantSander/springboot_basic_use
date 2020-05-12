package com.lant.springboot_basic_use.task;

public class OrderTask implements Runnable{
    private String orderName;

    public OrderTask(String orderName) {
        this.orderName = orderName;
    }

    public OrderTask() {
    }

    @Override
    public void run() {
        System.out.println("reduce orderTask--"+this.orderName);
    }
}
