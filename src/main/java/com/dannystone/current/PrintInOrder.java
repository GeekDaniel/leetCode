package com.dannystone.current;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/1/2 10:38 PM
 */
public class PrintInOrder {
    private volatile AtomicInteger firstPrintedCount = new AtomicInteger(0);
    private volatile AtomicInteger secondPrintedCount = new AtomicInteger(0);
    private volatile AtomicInteger thirdPrintedCount = new AtomicInteger(0);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrintedCount.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (secondPrintedCount.intValue() == 0) {
            while (firstPrintedCount.intValue() == 1 && secondPrintedCount.get() == 0) {
                printSecond.run();
                secondPrintedCount.incrementAndGet();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (thirdPrintedCount.intValue() == 0) {
            while (secondPrintedCount.intValue() == 1 && thirdPrintedCount.intValue() == 0) {
                printThird.run();
                thirdPrintedCount.incrementAndGet();
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        PrintInOrder printInOrder = new PrintInOrder();

        new Thread(()-> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

        new Thread(() -> {
            try {
                printInOrder.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
