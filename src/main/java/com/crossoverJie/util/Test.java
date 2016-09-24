package com.crossoverJie.util;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Test implements Runnable {
    public int i = 0;

    @Override
    public void run() {
        for (int j=0;j<=100;j++){
            i++ ;
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();

    }


}
